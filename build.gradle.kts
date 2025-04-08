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

dependencies {
    testImplementation(kotlin("test"))
    //implementation(kotlin("stdlib"))
    implementation("io.ktor:ktor-server-core:3.1.2")
    implementation("io.ktor:ktor-server-netty:3.1.2")
    implementation("ch.qos.logback:logback-classic:1.5.18")

}

tasks.test {
    useJUnitPlatform()
}