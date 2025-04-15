plugins {
    application
    kotlin("jvm") version "2.1.10"
}

group = "com.ihiviko"
version = "0.0.1"

application {
    mainClass.set("io.ktor.server.netty.EngineMain")
}
repositories {
    mavenCentral()
}

val ktor_version: String by project
val logback_version: String by project
val kotlin_version: String by project
dependencies {
    testImplementation(kotlin("test"))
    implementation("io.ktor:ktor-server-call-logging:$ktor_version")
    implementation("io.ktor:ktor-server-core:3.1.2")
    implementation("io.ktor:ktor-server-netty:$ktor_version")
    implementation("ch.qos.logback:logback-classic:$logback_version")

}

tasks.test {
    useJUnitPlatform()
}