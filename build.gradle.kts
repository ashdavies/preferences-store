import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("com.android.library") version "4.1.0-alpha09"
    id("com.github.ben-manes.versions") version "0.28.0"
    kotlin("android") version "1.3.72"

    `maven-publish`
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
            java.srcDirs("src/test/kotlin")
        }
    }
}

dependencies {
    implementation("androidx.core:core-ktx:1.3.0-rc01")
    implementation("org.jetbrains.kotlin:kotlin-stdlib:1.3.72")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.3.6")

    testImplementation("junit:junit:4.13")
    testImplementation("com.google.truth:truth:1.0.1")
    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.3.6")
}

repositories {
    gradlePluginPortal()
    mavenCentral()
    google()
}

tasks.configureEach<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

tasks.configureEach<Test> {
    testLogging.events("PASSED", "FAILED", "SKIPPED")
}

apply(
    from = "https://raw.githubusercontent.com/sky-uk/gradle-maven-plugin/master/gradle-mavenizer.gradle"
)
