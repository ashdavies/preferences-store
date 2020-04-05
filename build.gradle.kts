import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("com.android.library") version "4.1.0-alpha04"
    kotlin("android") version "1.3.70"
}

android {
    compileSdkVersion(29)

    defaultConfig {
        compileOptions {
            setSourceCompatibility(JavaVersion.VERSION_1_8)
            setTargetCompatibility(JavaVersion.VERSION_1_8)
        }

        minSdkVersion(14)
        targetSdkVersion(29)
    }

    sourceSets {
        get("main").apply {
            java.srcDirs("src/main/kotlin")
        }

        get("test").apply {
            java.srcDirs("src/main/kotlin")
        }
    }
}

tasks
        .withType<KotlinCompile>()
        .configureEach { kotlinOptions.jvmTarget = "1.8" }

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib:1.3.71")

    testImplementation("com.google.truth:truth:1.0.1")
    testImplementation("junit:junit:4.13")
}

repositories {
    gradlePluginPortal()
    mavenCentral()
    google()
}
