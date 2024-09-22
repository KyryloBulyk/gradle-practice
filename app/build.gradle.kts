plugins {
    java
    id("org.springframework.boot") version libs.versions.springBoot
    id("io.spring.dependency-management") version libs.versions.dependencyManagement
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.projectlombok:lombok")
    annotationProcessor("org.projectlombok:lombok")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
}

springBoot {
    mainClass.set("com.gradle.practice.GradlePracticeApplication")
}

val isProduction = project.hasProperty("production")

tasks.register("printEnvironment") {
    doLast {
        if (isProduction) {
            println("Production environment")
        } else {
            println("Development environment")
        }
    }
}

tasks.register("setupEnvironment") {
    doLast {
        if (isProduction) {
            println("Setting up production environment")
        } else {
            print("Setting up development environment")
        }
    }
}
