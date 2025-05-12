plugins {
	java
	id("org.springframework.boot") version "2.5.5"
	id("io.spring.dependency-management") version "1.1.2"
    kotlin("jvm")
}

group = "com.example"
version = "0.0.1-SNAPSHOT"

java {
}

configurations {
	compileOnly {
		extendsFrom(configurations.annotationProcessor.get())
	}
}

repositories {
	mavenCentral()
	maven { url = uri("https://repo.spring.io/milestone") }
	maven { url = uri("https://repo.spring.io/snapshot") }
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-security:2.6.6")
	implementation("org.springframework.boot:spring-boot-starter-web:2.6.6")
	compileOnly("org.projectlombok:lombok")
	annotationProcessor("org.projectlombok:lombok")
	testImplementation("org.springframework.boot:spring-boot-starter-test:2.6.6")
	testImplementation("junit:junit:4.13.2")
    implementation(kotlin("stdlib-jdk8"))
}

tasks.withType<Test> {
	useJUnitPlatform()
}
kotlin {
    jvmToolchain(11)
}