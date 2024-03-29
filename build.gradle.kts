import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "2.7.1"
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
    id("org.flywaydb.flyway") version "8.2.0"
    kotlin("jvm") version "1.6.21"
    kotlin("plugin.spring") version "1.6.21"
    kotlin("plugin.serialization") version "1.4.10"
}

group = "com.example"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation ("org.jetbrains.kotlin:kotlin-stdlib:1.7.20-Beta")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    implementation("org.postgresql:postgresql:42.3.6")
    implementation("org.springframework.boot:spring-boot-starter-jdbc")
    implementation("org.flywaydb:flyway-core")
    implementation("org.jetbrains.exposed", "exposed-core", "0.39.1")
    implementation("org.jetbrains.exposed", "exposed-dao", "0.39.1")
    implementation("org.jetbrains.exposed", "exposed-jdbc", "0.39.1")
    implementation("org.jetbrains.exposed", "spring-transaction", "0.39.1")
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "11"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}

tasks.register("migrateDevelopment", org.flywaydb.gradle.task.FlywayMigrateTask::class){
    url = "jdbc:postgresql://127.0.0.1:5432/post-service-training"
    user = "postgres"
    password = "password"
}

tasks.register("migrateTest", org.flywaydb.gradle.task.FlywayMigrateTask::class){
    url = "jdbc:postgresql://127.0.0.1:5432/post-service-training-test"
    user = "postgres"
    password = "password"
}
