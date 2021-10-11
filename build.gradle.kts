val ktor_version: String by project
val kotlin_version: String by project
val logback_version: String by project
val ktorm_version: String by project
val bcrypt_version: String by project
val h2_version: String by project

plugins {
    application
    kotlin("jvm") version "1.5.31"
}

group = "com.ihebchiha"
version = "0.0.1"
application {
    mainClass.set("io.ktor.server.netty.EngineMain")
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("io.ktor:ktor-server-core:$ktor_version")
    implementation("io.ktor:ktor-jackson:$ktor_version")
    implementation("io.ktor:ktor-server-host-common:$ktor_version")
    implementation("io.ktor:ktor-server-sessions:$ktor_version")
    implementation("io.ktor:ktor-auth:$ktor_version")
    implementation("io.ktor:ktor-auth-jwt:$ktor_version")
    implementation("io.ktor:ktor-server-netty:$ktor_version")
    implementation("ch.qos.logback:logback-classic:$logback_version")
    implementation("org.kodein.di:kodein-di:7.8.0")
//    implementation ("at.favre.lib:bcrypt:$bcrypt_version")
    implementation ("org.flywaydb:flyway-core:7.5.1")
    implementation ("com.zaxxer:HikariCP:3.4.2")
    implementation( "org.ktorm:ktorm-core:$ktorm_version")
    implementation("mysql:mysql-connector-java:8.0.26")
    implementation("org.mindrot:jbcrypt:0.4")
    compileOnly ("com.h2database:h2:$h2_version")
    compileOnly( "org.ktorm:ktorm-core:$ktorm_version")
    testImplementation("io.ktor:ktor-server-tests:$ktor_version")
    testImplementation("org.jetbrains.kotlin:kotlin-test:$kotlin_version")
}
