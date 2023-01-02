plugins {
    kotlin("jvm") version "1.7.20"
    idea
    java
    groovy
}

val JAVA_VERSION = 19;

group = "com.sputik"
version = "1.0"

repositories {
    mavenCentral()
    gradlePluginPortal()
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(JAVA_VERSION))
    }
}

kotlin {
    jvmToolchain {
        languageVersion.set(JavaLanguageVersion.of(JAVA_VERSION - 1))
    }
}

dependencies {
    testImplementation("org.assertj:assertj-core:3.23.1")
    testImplementation("org.junit.jupiter:junit-jupiter-engine:5.9.0")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.9.0")
    testImplementation("org.junit.jupiter:junit-jupiter-params:5.9.0")

    implementation(platform("org.jetbrains.kotlin:kotlin-bom"))
    testImplementation(kotlin("test"))
}

tasks.compileTestJava {
    options.encoding = "UTF-8"
}

tasks.wrapper {
    distributionType = Wrapper.DistributionType.ALL
}

tasks.test {
    ignoreFailures = true
    useJUnitPlatform()
}
