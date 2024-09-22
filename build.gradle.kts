plugins {
    `java-library`
    `maven-publish`
}

group = "com.gradle-practice"
version = "1.0.0"

allprojects {
    repositories {
        mavenCentral()
    }
}

subprojects {
    apply(plugin = "java-library")
    apply(plugin = "maven-publish")

    // Налаштування Java Toolchain
    java {
        toolchain {
            languageVersion.set(JavaLanguageVersion.of(17))
        }
    }

    // Налаштування публікацій
    publishing {
        publications {
            // Перевірка на наявність публікації, щоб уникнути дублювань
            if (findByName("mavenJava") == null) {
                create<MavenPublication>("mavenJava") {
                    from(components["java"])
                }
            }
        }
        repositories {
            mavenLocal()
        }
    }
}

// Завдання для деплою всіх модулів одночасно
tasks.register("publishAll") {
    dependsOn(subprojects.map { it.tasks.named("publish") })
}
