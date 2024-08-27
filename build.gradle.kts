import org.springframework.boot.gradle.tasks.bundling.BootJar


plugins {
	id("org.springframework.boot") version "3.3.2"
	id("io.spring.dependency-management") version "1.1.6"
	id("java")
	kotlin("jvm") version "1.9.24"
	kotlin("plugin.spring") version "1.9.24"
	kotlin("plugin.noarg") version "2.0.20"
	kotlin("plugin.jpa") version "2.0.20"
//	kotlin("plugin.allopen") version "2.0.20"

}

group = "com.example.sp61"
version = "0.0.1-SNAPSHOT"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(17)
	}
}

configurations {
	compileOnly {
		extendsFrom(configurations.annotationProcessor.get())
	}
}

repositories {
	mavenCentral()
}
noArg {
	annotation("com.example.sp61.annotation.NoArg")
//	invokeInitializers = true
}
//allOpen {
//	annotation("com.example.sp61.annotation.NoArg")
//	// annotations("com.another.Annotation", "com.third.Annotation")
//}

val log4jV = "2.19.0"

dependencies {


	implementation("org.springframework.boot:spring-boot-starter-web"){

	}
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	//日志相关
//	implementation("org.apache.logging.log4j:log4j-api:$log4jV")
//	implementation("org.apache.logging.log4j:log4j-core:$log4jV")
//	implementation("org.apache.logging.log4j:log4j-slf4j-impl:$log4jV")
//	implementation("org.springframework.boot:spring-boot-starter-log4j2"){
//		exclude(group = "org.apache.logging.log4j",module = "log4j-slf4j2-impl")
//	}
	//注解相关
//	implementation("org.springframework:spring-aspects:6.1.11")
//	implementation("org.springframework:spring-aop:6.1.11")
	implementation("org.springframework.boot:spring-boot-starter-aop:3.3.2")
	implementation("org.springframework.boot:spring-boot-starter-data-jpa:3.3.2")
	//数据库相关
//	implementation("com.alibaba:druid:1.2.23")
	implementation("com.alibaba:druid-spring-boot-3-starter:1.2.23"){
//		exclude(group = "org.slf4j")
	}
//	implementation("org.springframework:spring-jdbc:6.1.11")
	implementation("org.springframework.boot:spring-boot-starter-jdbc")
	implementation("mysql:mysql-connector-java:8.0.33")
//	implementation("org.springframework:spring-tx:6.1.11")
	//mybatis
//	implementation("org.mybatis:mybatis:3.5.16")
	implementation("org.mybatis.spring.boot:mybatis-spring-boot-starter:3.0.3")
	implementation("com.baomidou:mybatis-plus-boot-starter:3.5.7")
	//JWT相关
	implementation("io.jsonwebtoken:jjwt:0.12.6")
	implementation("javax.xml.bind:jaxb-api:2.3.1")
	//Kotlin相关
	implementation("org.jetbrains.kotlin:kotlin-maven-noarg:2.0.20-RC2")
//	implementation("org.jetbrains.kotlin:kotlin-maven-allopen:2.0.20-RC2")
//	implementation("org.jetbrains.kotlin:kotlin-noarg:2.0.20-RC2")
	//Gson
	implementation("com.google.code.gson:gson:2.11.0")

	developmentOnly("org.springframework.boot:spring-boot-devtools")
	annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

kotlin {
	compilerOptions {
		freeCompilerArgs.addAll("-Xjsr305=strict")
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}
//Gradle打包Jar配置 mainClass需要加Kt后缀,会自动生成一个 Sp61ApplicationKt.class包含main方法
springBoot{
	mainClass = "com.example.sp61.Sp61ApplicationKt"
}
tasks.withType<Jar> {
	duplicatesStrategy = DuplicatesStrategy.EXCLUDE
}