import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.6.10"
    application
    id("com.github.johnrengelman.shadow") version "5.1.0"
}

group = "com.adblock"
version = "1.0"

repositories {
    mavenCentral()
}


tasks.withType<KotlinCompile>() {
    kotlinOptions.jvmTarget = "1.8"
}

application {
    mainClassName = "MainKt"
}

dependencies {
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.5.2")

    implementation("com.sun.mail:javax.mail:1.5.5")
    implementation("javax.mail:mail:1.4.1")

    implementation("org.jsoup:jsoup:1.14.3")

    implementation("com.google.code.gson:gson:2.8.9")

    implementation("org.quartz-scheduler:quartz:2.3.2")

    implementation("com.squareup.okhttp3:okhttp:4.10.0")

    implementation(kotlin("stdlib-jdk8"))
}