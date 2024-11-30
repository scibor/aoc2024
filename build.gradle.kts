plugins {
    java
    id("org.assertj.generator") version "1.1.0"
    application
    id("com.github.johnrengelman.shadow") version "8.1.1"
}

group = "aoc2024"
version = "1.0.0"

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(21))
    }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.slf4j:slf4j-api:2.0.16")
    implementation("org.assertj:assertj-assertions-generator:2.2.1")
    implementation("javax.annotation:javax.annotation-api:1.3.2")

    runtimeOnly("ch.qos.logback:logback-classic:1.5.12")

    testImplementation("org.testng:testng:7.10.2")
    testImplementation("org.assertj:assertj-core:3.26.3")
}

application {
    mainClass.set("profiling.Main")
}

tasks {
    shadowJar {
        archiveBaseName.set("aoc2024")
        archiveVersion.set("1.0.0")
        archiveClassifier.set("profiling")
    }
    register("createJfrFile") {
        doLast {
            exec {
                commandLine("./gradlew.bat", "clean", "shadowJar")
            }
            exec {
                commandLine("java", "-XX:StartFlightRecording:filename=profiling.jfr", "-jar", "build/libs/aoc2024-1.0.0-profiling.jar")
            }
        }
    }
}

tasks.test {
    useTestNG()
}