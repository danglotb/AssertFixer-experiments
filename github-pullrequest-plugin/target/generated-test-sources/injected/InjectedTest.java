import java.util.*;
/**
 * Entry point to auto-generated tests (generated by maven-hpi-plugin).
 * If this fails to compile, you are probably using Hudson &lt; 1.327. If so, disable
 * this code generation by configuring maven-hpi-plugin to &lt;disabledTestInjection&gt;true&lt;/disabledTestInjection&gt;.
 */
public class InjectedTest extends junit.framework.TestCase {
  public static junit.framework.Test suite() throws Exception {
    System.out.println("Running tests for "+"org.jenkins-ci.plugins:github-pullrequest:0.2.0-SNAPSHOT");
    Map<String, Object> parameters = new HashMap<String, Object>();
    parameters.put("basedir","/root/workspace/KostyaSha/github-integration-plugin/388416402/github-pullrequest-plugin");
    parameters.put("artifactId","github-pullrequest");
    parameters.put("packaging","hpi");
    parameters.put("outputDirectory","/root/workspace/KostyaSha/github-integration-plugin/388416402/github-pullrequest-plugin/target/classes");
    parameters.put("testOutputDirectory","/root/workspace/KostyaSha/github-integration-plugin/388416402/github-pullrequest-plugin/target/test-classes");
    parameters.put("requirePI","true");
    return org.jvnet.hudson.test.PluginAutomaticTestBuilder.build(parameters);
  }
}
