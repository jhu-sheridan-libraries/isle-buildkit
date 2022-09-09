buildscript {
    repositories {
        gradlePluginPortal()
        maven {
            url = uri("https://plugins.gradle.org/m2/")
        }
        mavenCentral()
    }
    dependencies {
        classpath("ca.islandora:isle-gradle-docker-plugin:0.0.1")
        classpath("com.palantir.gradle.gitversion:gradle-git-version:0.12.3")
        classpath("org.owasp:dependency-check-gradle:7.1.2")
    }
}

allprojects {
    apply(plugin = "com.palantir.git-version")
    val gitVersion: groovy.lang.Closure<String> by extra
    if (version == "unspecified" || version.toString().trim() == "") {
      version = gitVersion()
    }
}

apply(plugin = "ca.islandora.gradle.docker")
apply(plugin = "org.owasp.dependencycheck")