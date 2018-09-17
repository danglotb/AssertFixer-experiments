package com.github.mike10004.seleniumhelp;

import com.github.mike10004.nativehelper.subprocess.ProcessResult;
import com.github.mike10004.nativehelper.subprocess.Subprocess;
import com.google.common.io.Files;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.function.Function;

import static java.util.Objects.requireNonNull;

/**
 * Keystore file creator implementation that uses an {@code openssl} executable.
 */
public class OpensslKeystoreFileCreator implements KeystoreFileCreator {

    private static final String EXEC_NAME_KEYTOOL = "keytool";
    private static final String EXEC_NAME_OPENSSL = "openssl";

    private static final Logger log = LoggerFactory.getLogger(OpensslKeystoreFileCreator.class);

    private final ExecutableConfig keytoolConfig;
    private final ExecutableConfig opensslConfig;
    private final File scratchDir;

    public OpensslKeystoreFileCreator() {
        this(ExecutableConfig.byNameOnly(EXEC_NAME_KEYTOOL), ExecutableConfig.byNameOnly(EXEC_NAME_OPENSSL));
    }

    public OpensslKeystoreFileCreator(ExecutableConfig keytoolConfig, ExecutableConfig opensslConfig) {
        this.keytoolConfig = requireNonNull(keytoolConfig);
        this.opensslConfig = requireNonNull(opensslConfig);
        scratchDir = FileUtils.getTempDirectory();
    }

    /**
     * Creates a PKCS12-format file.
     *
     * <p>
     * See https://stackoverflow.com/questions/652916/converting-a-java-keystore-into-pem-format
     * for instructions on how to convert the .keystore file into a .pem file that can be installed
     * into browsers like Firefox.
     *
     * <p>In short, if {@code $KEYSTORE_FILE} is the file generated by this program, execute:
     * <pre>
     *     $ keytool -importkeystore -srckeystore $KEYSTORE_FILE -destkeystore temp.p12 -srcstoretype jks  -deststoretype pkcs12
     *     $ openssl pkcs12 -in temp.p12 -out exported-keystore.pem
     * </pre>
     * <p>The contents of `exported-keystore.pem` will be in PEM format.
     */
    @Override
    public void createPKCS12File(KeystoreInput keystore, File p12File) throws IOException {
        File keystoreFile = File.createTempFile("AutoCertificateAndKeySource", ".keystore", scratchDir);
        try {
            keystore.getBytes().copyTo(Files.asByteSink(keystoreFile));
            String keystorePassword = keystore.getPassword();
            {
                Subprocess program = keytoolConfig.subprocessBuilder()
                        .arg("-importkeystore")
                        .args("-srckeystore", keystoreFile.getAbsolutePath())
                        .args("-srcstoretype", "jks")
                        .args("-srcstorepass", keystorePassword)
                        .args("-destkeystore", p12File.getAbsolutePath())
                        .args("-deststoretype", "pkcs12")
                        .args("-deststorepass", keystorePassword)
                        .build();
                executeSubprocessAndCheckResult(program, keytoolResult -> {
                    throw new NonzeroExitFromCertProgramException("keytool", keytoolResult);
                });
                if (p12File.length() <= 0) {
                    throw new AutoCertificateAndKeySource.CertificateGenerationException("pkcs12 file has invalid length: " + p12File.length());
                }
                log.debug("pkcs12: {} ({} bytes)%n", p12File, p12File.length());
            }
        } finally {
            FileUtils.forceDelete(keystoreFile);
        }
    }

    @SuppressWarnings("RedundantThrows")
    @Override
    public void createPemFile(File pkcs12File, String keystorePassword, File pemFile) throws IOException {
        Subprocess subprocess = opensslConfig.subprocessBuilder()
                .arg("pkcs12")
                .args("-in", pkcs12File.getAbsolutePath())
                .args("-passin", "pass:" + keystorePassword)
                .arg("-nodes")
                .args("-out", pemFile.getAbsolutePath())
                .build();
        executeSubprocessAndCheckResult(subprocess, opensslResult -> {
            return new NonzeroExitFromCertProgramException("openssl", opensslResult);
        });
        log.debug("pem: {} ({} bytes)", pemFile, pemFile.length());
    }

    private <X extends Throwable> void executeSubprocessAndCheckResult(Subprocess subprocess, Function<ProcessResult<String, String>, X> nonzeroExitReaction) throws X {
        ProcessResult<String, String> result;
        try {
            result = Subprocesses.executeAndWait(subprocess, Charset.defaultCharset(), null);
        }  catch (InterruptedException e) {
            throw new AutoCertificateAndKeySource.CertificateGenerationException(e);
        }
        if (result.exitCode() != 0) {
            log.error("exit code {} from {} with arguments {}", result.exitCode(), subprocess.executable(), subprocess.arguments());
            String stdout = StringUtils.abbreviateMiddle(result.content().stdout(), "[...]", 256);
            String stderr = StringUtils.abbreviateMiddle(result.content().stderr(), "[...]", 256);
            log.error("stderr {}", stderr.isEmpty() ? "<empty>" : stderr);
            log.error("stdout {}", stdout.isEmpty() ? "<empty>" : stdout);
            X ex = nonzeroExitReaction.apply(result);
            if (ex != null) {
                throw ex;
            }
        }
    }
}
