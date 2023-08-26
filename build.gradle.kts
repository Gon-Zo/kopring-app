import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "3.1.2"
    id("io.spring.dependency-management") version "1.1.2"
    kotlin("jvm") version "1.8.22"
    kotlin("plugin.spring") version "1.8.22"
}

group = "com.example"
version = "0.0.1-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_17
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")

    //thymeleaf
    implementation("org.springframework.boot:spring-boot-starter-thymeleaf:2.5.5")
    implementation("nz.net.ultraq.thymeleaf:thymeleaf-layout-dialect")

    //looger
    implementation("io.github.microutils:kotlin-logging-jvm:2.0.6")

    // jasypt
    implementation("com.github.ulisesbocchio:jasypt-spring-boot-starter:1.17")

//     mysql
//    implementation("mysql:mysql-connector-java")
    implementation("com.h2database:h2")

    // jpa
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs += "-Xjsr305=strict"
        jvmTarget = "17"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}
