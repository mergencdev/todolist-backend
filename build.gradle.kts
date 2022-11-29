val ktor_version: String by project
val kotlin_version: String by project
val logback_version: String by project

plugins {
    application
    kotlin("jvm") version "1.7.22"
    id("io.ktor.plugin") version "2.1.3"
}

group = "com.mergenc"
version = "0.0.1"
application {
    mainClass.set("com.mergenc.ApplicationKt")

    val isDevelopment: Boolean = project.ext.has("development")
    applicationDefaultJvmArgs = listOf("-Dio.ktor.development=$isDevelopment")
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("io.ktor:ktor-server-core-jvm:$ktor_version")
    implementation("io.ktor:ktor-server-netty-jvm:$ktor_version")
    implementation("ch.qos.logback:logback-classic:$logback_version")
    implementation("io.ktor:ktor-server-call-logging-jvm:2.1.3")
    implementation("io.ktor:ktor-server-content-negotiation-jvm:2.1.3")
    implementation("io.ktor:ktor-serialization-gson-jvm:2.1.3")
    testImplementation("io.ktor:ktor-server-tests-jvm:$ktor_version")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit:$kotlin_version")

    // https://mvnrepository.com/artifact/io.ktor/ktor-gson
    implementation("io.ktor:ktor-gson:1.6.8")
    implementation("mysql:mysql-connector-java:8.0.30")
    implementation("org.ktorm:ktorm-core:3.5.0")
    implementation("org.ktorm:ktorm-support-mysql:3.5.0")
}