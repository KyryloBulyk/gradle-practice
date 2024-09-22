plugins {
    `java-library`
}

group = "com.gradle.customlibrary"
version = "1.0.0"

repositories {
    mavenCentral()
}

dependencies {
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
}