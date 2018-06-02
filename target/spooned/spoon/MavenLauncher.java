package spoon;


public class MavenLauncher extends spoon.Launcher {
    private java.lang.String m2RepositoryPath;

    private spoon.MavenLauncher.SOURCE_TYPE sourceType;

    public enum SOURCE_TYPE {
        APP_SOURCE, TEST_SOURCE, ALL_SOURCE;}

    public MavenLauncher(java.lang.String mavenProject, spoon.MavenLauncher.SOURCE_TYPE sourceType) {
        this(mavenProject, java.nio.file.Paths.get(java.lang.System.getProperty("user.home"), ".m2", "repository").toString(), sourceType);
    }

    public MavenLauncher(java.lang.String mavenProject, java.lang.String m2RepositoryPath, spoon.MavenLauncher.SOURCE_TYPE sourceType) {
        super();
        this.m2RepositoryPath = m2RepositoryPath;
        this.sourceType = sourceType;
        java.io.File mavenProjectFile = new java.io.File(mavenProject);
        if (!(mavenProjectFile.exists())) {
            throw new spoon.SpoonException((mavenProject + " does not exist."));
        }
        spoon.MavenLauncher.InheritanceModel model;
        try {
            model = readPOM(mavenProject, null);
        } catch (java.lang.Exception e) {
            throw new spoon.SpoonException("Unable to read the pom", e);
        }
        if (model == null) {
            throw new spoon.SpoonException("Unable to create the model, pom not found?");
        }
        if (((spoon.MavenLauncher.SOURCE_TYPE.APP_SOURCE) == sourceType) || ((spoon.MavenLauncher.SOURCE_TYPE.ALL_SOURCE) == sourceType)) {
            java.util.List<java.io.File> sourceDirectories = model.getSourceDirectories();
            for (java.io.File sourceDirectory : sourceDirectories) {
                this.addInputResource(sourceDirectory.getAbsolutePath());
            }
        }
        if (((spoon.MavenLauncher.SOURCE_TYPE.TEST_SOURCE) == sourceType) || ((spoon.MavenLauncher.SOURCE_TYPE.ALL_SOURCE) == sourceType)) {
            java.util.List<java.io.File> testSourceDirectories = model.getTestDirectories();
            for (java.io.File sourceDirectory : testSourceDirectories) {
                this.addInputResource(sourceDirectory.getAbsolutePath());
            }
        }
        java.util.List<java.io.File> dependencies = model.getDependencies(false, new java.util.HashSet<>());
        java.lang.String[] classpath = new java.lang.String[dependencies.size()];
        for (int i = 0; i < (dependencies.size()); i++) {
            java.io.File file = dependencies.get(i);
            classpath[i] = file.getAbsolutePath();
        }
        this.getModelBuilder().setSourceClasspath(classpath);
        this.getEnvironment().setComplianceLevel(model.getSourceVersion());
    }

    private spoon.MavenLauncher.InheritanceModel readPOM(java.lang.String path, spoon.MavenLauncher.InheritanceModel parent) throws java.io.IOException, org.codehaus.plexus.util.xml.pull.XmlPullParserException {
        if ((!(path.endsWith(".xml"))) && (!(path.endsWith(".pom")))) {
            path = java.nio.file.Paths.get(path, "pom.xml").toString();
        }
        java.io.File pomFile = new java.io.File(path);
        if (!(pomFile.exists())) {
            return null;
        }
        org.apache.maven.model.io.xpp3.MavenXpp3Reader pomReader = new org.apache.maven.model.io.xpp3.MavenXpp3Reader();
        try (java.io.FileReader reader = new java.io.FileReader(pomFile)) {
            org.apache.maven.model.Model model = pomReader.read(reader);
            spoon.MavenLauncher.InheritanceModel inheritanceModel = new spoon.MavenLauncher.InheritanceModel(model, parent, pomFile.getParentFile());
            for (java.lang.String module : model.getModules()) {
                if (path.contains(m2RepositoryPath)) {
                    spoon.MavenLauncher.InheritanceModel modulePom = readPOM(path.replaceAll(model.getArtifactId(), module), inheritanceModel);
                    if (modulePom != null) {
                        inheritanceModel.addModule(modulePom);
                    }
                }else {
                    inheritanceModel.addModule(readPOM(java.nio.file.Paths.get(pomFile.getParent(), module).toString(), inheritanceModel));
                }
            }
            return inheritanceModel;
        }
    }

    class InheritanceModel {
        private java.util.List<spoon.MavenLauncher.InheritanceModel> modules = new java.util.ArrayList<>();

        private org.apache.maven.model.Model model;

        private spoon.MavenLauncher.InheritanceModel parent;

        private java.io.File directory;

        private java.util.Map<java.lang.String, java.lang.String> dependencyManagements = new java.util.HashMap<>();

        InheritanceModel(org.apache.maven.model.Model model, spoon.MavenLauncher.InheritanceModel parent, java.io.File directory) {
            this.model = model;
            this.parent = parent;
            this.directory = directory;
            if ((parent == null) && ((model.getParent()) != null)) {
                try {
                    java.io.File parentPath = new java.io.File(directory, model.getParent().getRelativePath());
                    this.parent = readPOM(parentPath.getPath(), null);
                    if ((this.parent) == null) {
                        java.lang.String groupId = model.getParent().getGroupId();
                        java.lang.String version = model.getParent().getVersion();
                        this.parent = readPom(groupId, model.getParent().getArtifactId(), version);
                        if ((this.parent) != null) {
                            this.parent.modules.add(this);
                        }
                    }
                } catch (java.lang.Exception e) {
                    spoon.Launcher.LOGGER.debug(("Parent model cannot be resolved: " + (e.getMessage())));
                }
            }
            org.apache.maven.model.DependencyManagement dependencyManagement = model.getDependencyManagement();
            if (dependencyManagement != null) {
                java.util.List<org.apache.maven.model.Dependency> dependencies = dependencyManagement.getDependencies();
                for (org.apache.maven.model.Dependency dependency : dependencies) {
                    if ("import".equals(dependency.getScope())) {
                        spoon.MavenLauncher.InheritanceModel pom = readPom(dependency.getGroupId(), dependency.getArtifactId(), dependency.getVersion());
                        if (pom != null) {
                            for (java.lang.String depKey : pom.dependencyManagements.keySet()) {
                                if (!(dependencyManagements.containsKey(depKey))) {
                                    dependencyManagements.put(depKey, pom.dependencyManagements.get(depKey));
                                }
                            }
                        }
                    }else {
                        java.lang.String depKey = ((dependency.getGroupId()) + ":") + (dependency.getArtifactId());
                        if (!(dependencyManagements.containsKey(depKey))) {
                            dependencyManagements.put(depKey, extractVersion(dependency.getGroupId(), dependency.getArtifactId(), dependency.getVersion()));
                        }
                    }
                }
            }
        }

        public void addModule(spoon.MavenLauncher.InheritanceModel module) {
            modules.add(module);
        }

        public org.apache.maven.model.Model getModel() {
            return model;
        }

        public spoon.MavenLauncher.InheritanceModel getParent() {
            return parent;
        }

        public java.util.List<java.io.File> getSourceDirectories() {
            java.util.List<java.io.File> output = new java.util.ArrayList<>();
            java.lang.String sourcePath = null;
            org.apache.maven.model.Build build = model.getBuild();
            if (build != null) {
                sourcePath = build.getSourceDirectory();
            }
            if (sourcePath == null) {
                sourcePath = java.nio.file.Paths.get(directory.getAbsolutePath(), "src", "main", "java").toString();
            }
            java.io.File source = new java.io.File(sourcePath);
            if (source.exists()) {
                output.add(source);
            }
            java.io.File generatedSource = java.nio.file.Paths.get(directory.getAbsolutePath(), "target", "generated-sources").toFile();
            if (generatedSource.exists()) {
                output.add(generatedSource);
            }
            for (spoon.MavenLauncher.InheritanceModel module : modules) {
                output.addAll(module.getSourceDirectories());
            }
            return output;
        }

        public java.util.List<java.io.File> getTestDirectories() {
            java.util.List<java.io.File> output = new java.util.ArrayList<>();
            java.lang.String sourcePath = null;
            org.apache.maven.model.Build build = model.getBuild();
            if (build != null) {
                sourcePath = build.getTestSourceDirectory();
            }
            if (sourcePath == null) {
                sourcePath = java.nio.file.Paths.get(directory.getAbsolutePath(), "src", "test", "java").toString();
            }
            java.io.File source = new java.io.File(sourcePath);
            if (source.exists()) {
                output.add(source);
            }
            java.io.File generatedSource = java.nio.file.Paths.get(directory.getAbsolutePath(), "target", "generated-test-sources").toFile();
            if (generatedSource.exists()) {
                output.add(generatedSource);
            }
            for (spoon.MavenLauncher.InheritanceModel module : modules) {
                output.addAll(module.getTestDirectories());
            }
            return output;
        }

        private java.lang.String extractVariable(java.lang.String value) {
            if ((value != null) && (value.startsWith("$"))) {
                value = getProperty(value.substring(2, ((value.length()) - 1)));
            }
            return value;
        }

        private java.lang.String extractVersion(java.lang.String groupId, java.lang.String artifactId, java.lang.String version) {
            if (version == null) {
                java.lang.String depKey = (groupId + ":") + artifactId;
                if (dependencyManagements.containsKey(depKey)) {
                    return dependencyManagements.get(depKey);
                }else
                    if ((this.parent) != null) {
                        return this.parent.extractVersion(groupId, artifactId, version);
                    }

            }
            version = extractVariable(version);
            if ((version != null) && (version.startsWith("["))) {
                version = version.substring(1, version.indexOf(','));
            }
            return version;
        }

        private spoon.MavenLauncher.InheritanceModel readPom(java.lang.String groupId, java.lang.String artifactId, java.lang.String version) {
            version = extractVersion(groupId, artifactId, version);
            groupId = groupId.replace(".", "/");
            java.lang.String fileName = (artifactId + "-") + version;
            java.nio.file.Path depPath = java.nio.file.Paths.get(m2RepositoryPath, groupId, artifactId, version, (fileName + ".pom"));
            try {
                return readPOM(depPath.toString(), null);
            } catch (java.lang.Exception e) {
                return null;
            }
        }

        private java.util.Set<java.io.File> getDependencies(java.lang.String groupId, java.lang.String artifactId, java.lang.String version, java.lang.String scope, boolean isOptional, boolean isLib, java.util.Set<java.lang.String> hierarchy) {
            java.util.Set<java.io.File> output = new java.util.HashSet<>();
            version = extractVersion(groupId, artifactId, version);
            if (version == null) {
                spoon.Launcher.LOGGER.warn(((((("A dependency version cannot be resolved: " + groupId) + ":") + artifactId) + ":") + version));
                return output;
            }
            groupId = groupId.replace(".", "/");
            if (isLib && isOptional) {
                return output;
            }
            if (("test".equals(scope)) && ((spoon.MavenLauncher.SOURCE_TYPE.APP_SOURCE) == (sourceType))) {
                return output;
            }
            if (isLib && (("test".equals(scope)) || ("provided".equals(scope)))) {
                spoon.Launcher.LOGGER.log(org.apache.log4j.Level.WARN, ((((("Dependency ignored (scope: provided or test): " + groupId) + ":") + artifactId) + ":") + version));
                return output;
            }
            java.lang.String fileName = (artifactId + "-") + version;
            java.nio.file.Path depPath = java.nio.file.Paths.get(m2RepositoryPath, groupId, artifactId, version);
            java.io.File depFile = depPath.toFile();
            if (depFile.exists()) {
                java.io.File jarFile = java.nio.file.Paths.get(depPath.toString(), (fileName + ".jar")).toFile();
                if (jarFile.exists()) {
                    output.add(jarFile);
                    java.lang.String depKey = ((groupId.replace("/", ".")) + ":") + artifactId;
                    if (!(dependencyManagements.containsKey(depKey))) {
                        dependencyManagements.put(depKey, version);
                    }
                }else {
                    getEnvironment().setNoClasspath(true);
                }
                try {
                    spoon.MavenLauncher.InheritanceModel dependencyModel = readPom(groupId, artifactId, version);
                    output.addAll(dependencyModel.getDependencies(true, hierarchy));
                } catch (java.lang.Exception ignore) {
                    ignore.printStackTrace();
                }
            }else {
                getEnvironment().setNoClasspath(true);
            }
            return output;
        }

        public java.util.List<java.io.File> getDependencies(boolean isLib, java.util.Set<java.lang.String> hierarchy) {
            java.util.Set<java.io.File> output = new java.util.HashSet<>();
            java.lang.String modelKey = ((((model.getGroupId()) + ":") + (model.getArtifactId())) + ":") + (model.getVersion());
            if (hierarchy.contains(modelKey)) {
                return new java.util.ArrayList<>(output);
            }
            hierarchy.add(modelKey);
            if ((this.parent) != null) {
                output.addAll(this.parent.getDependencies(isLib, hierarchy));
            }
            java.util.List<org.apache.maven.model.Dependency> dependencies = model.getDependencies();
            for (org.apache.maven.model.Dependency dependency : dependencies) {
                output.addAll(getDependencies(dependency.getGroupId(), dependency.getArtifactId(), dependency.getVersion(), dependency.getScope(), dependency.isOptional(), isLib, hierarchy));
            }
            for (spoon.MavenLauncher.InheritanceModel module : modules) {
                output.addAll(module.getDependencies(isLib, hierarchy));
            }
            return new java.util.ArrayList<>(output);
        }

        private java.lang.String getProperty(java.lang.String key) {
            if ("project.version".equals(key)) {
                if ((model.getVersion()) != null) {
                    return model.getVersion();
                }
            }
            java.lang.String value = model.getProperties().getProperty(key);
            if (value == null) {
                if ((parent) == null) {
                    return null;
                }
                return parent.getProperty(key);
            }
            return value;
        }

        public int getSourceVersion() {
            if ((model.getBuild()) != null) {
                for (org.apache.maven.model.Plugin plugin : model.getBuild().getPlugins()) {
                    if (!("maven-compiler-plugin".equals(plugin.getArtifactId()))) {
                        continue;
                    }
                    org.codehaus.plexus.util.xml.Xpp3Dom configuration = ((org.codehaus.plexus.util.xml.Xpp3Dom) (plugin.getConfiguration()));
                    org.codehaus.plexus.util.xml.Xpp3Dom source = configuration.getChild("source");
                    if (source != null) {
                        return java.lang.Integer.parseInt(extractVariable(source.getValue()).substring(2));
                    }
                    break;
                }
            }
            java.lang.String javaVersion = getProperty("java.version");
            if (javaVersion != null) {
                return java.lang.Integer.parseInt(extractVariable(javaVersion).substring(2));
            }
            javaVersion = getProperty("java.src.version");
            if (javaVersion != null) {
                return java.lang.Integer.parseInt(extractVariable(javaVersion).substring(2));
            }
            javaVersion = getProperty("maven.compiler.source");
            if (javaVersion != null) {
                return java.lang.Integer.parseInt(extractVariable(javaVersion).substring(2));
            }
            javaVersion = getProperty("maven.compile.source");
            if (javaVersion != null) {
                return java.lang.Integer.parseInt(extractVariable(javaVersion).substring(2));
            }
            return getEnvironment().getComplianceLevel();
        }

        @java.lang.Override
        public java.lang.String toString() {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append((((((model.getGroupId()) + ":") + (model.getArtifactId())) + ":") + (model.getVersion())));
            if (modules.isEmpty()) {
                return sb.toString();
            }
            sb.append(" {\n");
            for (int i = 0; i < (modules.size()); i++) {
                spoon.MavenLauncher.InheritanceModel inheritanceModel = modules.get(i);
                java.lang.String child = inheritanceModel.toString();
                for (java.lang.String s : child.split("\n")) {
                    sb.append("\t");
                    sb.append(s);
                    sb.append("\n");
                }
            }
            sb.append("}");
            return sb.toString();
        }
    }
}

