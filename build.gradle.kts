import org.springframework.boot.gradle.tasks.bundling.BootJar

plugins {
    java
    id("org.springframework.boot") version "3.4.0"
    id("io.spring.dependency-management") version "1.1.6"
    id("org.graalvm.buildtools.native") version "0.10.3"
}

repositories {
    maven { url = uri("https://maven.aliyun.com/repository/central") }
    maven { url = uri("https://maven.aliyun.com/repository/public") }
    maven { url = uri("https://maven.aliyun.com/repository/spring") }
    maven { url = uri("https://maven.aliyun.com/repository/google") }
    maven { url = uri("https://maven.aliyun.com/repository/gradle-plugin") }
    maven { url = uri("https://maven.aliyun.com/repository/spring-plugin") }
}

dependencyManagement {
    imports {
        mavenBom("org.springframework.boot:spring-boot-dependencies:3.4.0")
        mavenBom("cn.hutool:hutool-bom:5.8.33")
        mavenBom("io.netty:netty-bom:4.1.115.Final")
    }
    dependencies {
        // spring-authorization-server
        dependency("org.springframework.security:spring-security-oauth2-authorization-server:1.4.0")
        // swagger
        dependency("io.swagger.core.v3:swagger-core-jakarta:2.2.25")
        dependency("io.swagger.core.v3:swagger-annotations-jakarta:2.2.25")
        dependency("io.swagger.core.v3:swagger-models-jakarta:2.2.25")
        dependency("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.6.0")
        // redisson
        dependency("org.redisson:redisson:3.39.0")
        dependency("org.redisson:redisson-spring-data-33:3.39.0")
        dependency("org.redisson:redisson-spring-boot-starter:3.39.0")
        // mapstruct
        dependency("org.mapstruct:mapstruct:1.6.3")
        dependency("org.mapstruct:mapstruct-processor:1.6.3")
        dependency("org.projectlombok:lombok-mapstruct-binding:0.2.0")
        // commons
        dependency("commons-io:commons-io:2.17.0")
        dependency("commons-codec:commons-codec:1.17.1")
        dependency("org.apache.commons:commons-text:1.12.0")
        dependency("org.apache.commons:commons-lang3:3.17.0")
        // 3rd party
        dependency("org.ow2.asm:asm:9.7.1")
        dependency("io.minio:minio:8.5.13")
        dependency("org.dom4j:dom4j:2.1.4")
        dependency("com.google.zxing:core:3.5.3")
        dependency("com.google.zxing:javase:3.5.3")
        dependency("com.google.guava:guava:33.3.1-jre")
        dependency("com.nimbusds:nimbus-jose-jwt:9.47")
        dependency("com.aliyun:dysmsapi20170525:3.0.0")
        dependency("com.github.binarywang:weixin-java-cp:4.6.0")
        dependency("com.github.binarywang:weixin-java-mp:4.6.0")
        dependency("com.github.binarywang:weixin-java-pay:4.6.0")
        dependency("com.github.binarywang:weixin-java-miniapp:4.6.0")
        dependency("org.bouncycastle:bcpkix-jdk18on:1.79")
        dependency("org.bouncycastle:bcprov-jdk18on:1.79")
        dependency("org.bouncycastle:bcutil-jdk18on:1.79")
        dependency("com.taobao.arthas:arthas-packaging:4.0.4")
        dependency("com.taobao.arthas:arthas-agent-attach:4.0.4")
        dependency("com.taobao.arthas:arthas-spring-boot-starter:4.0.4")
        // 用于排除重复依赖
        dependency("org.apache.httpcomponents:httpcore:4.4.16")
        dependency("org.apache.httpcomponents:httpcore-nio:4.4.16")
        dependency("org.apache.httpcomponents:httpmime:4.5.14")
        dependency("org.apache.httpcomponents:httpclient:4.5.14")
    }
}

dependencies {
    // spring
    implementation("org.springframework.boot:spring-boot-starter-aop")
    implementation("org.springframework.boot:spring-boot-starter-mail")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-websocket")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-security")
    implementation("org.springframework.boot:spring-boot-starter-oauth2-resource-server")
    implementation("org.springframework.security:spring-security-oauth2-authorization-server")
    // hibernate
    implementation("org.hibernate.orm:hibernate-core")
    implementation("org.hibernate.orm:hibernate-graalvm")
    // springdoc
    implementation("io.swagger.core.v3:swagger-core-jakarta")
    implementation("io.swagger.core.v3:swagger-annotations-jakarta")
    implementation("io.swagger.core.v3:swagger-models-jakarta")
    implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui")
    // redisson
    implementation("org.redisson:redisson")
    implementation("org.redisson:redisson-spring-data-33")
    implementation("org.redisson:redisson-spring-boot-starter")
    // 3rd party
    implementation("io.minio:minio")
    implementation("org.dom4j:dom4j")
    implementation("org.thymeleaf:thymeleaf")
    implementation("com.mysql:mysql-connector-j")
    implementation("com.google.guava:guava")
    implementation("com.nimbusds:nimbus-jose-jwt")
    implementation("com.aliyun:dysmsapi20170525")
    implementation("cn.hutool:hutool-captcha")
    implementation("com.github.binarywang:weixin-java-cp")
    implementation("com.github.binarywang:weixin-java-mp")
    implementation("com.github.binarywang:weixin-java-pay")
    implementation("com.github.binarywang:weixin-java-miniapp")
    implementation("org.bouncycastle:bcpkix-jdk18on")
    implementation("org.bouncycastle:bcprov-jdk18on")
    implementation("org.bouncycastle:bcutil-jdk18on")
    // commons
    implementation("commons-io:commons-io")
    implementation("commons-codec:commons-codec")
    implementation("org.apache.commons:commons-text")
    implementation("org.apache.commons:commons-lang3")
    // arthas
    implementation("com.taobao.arthas:arthas-agent-attach")
    implementation("com.taobao.arthas:arthas-packaging")
    // dev
    implementation("org.mapstruct:mapstruct")
    implementation("org.projectlombok:lombok")
    annotationProcessor("org.projectlombok:lombok-mapstruct-binding")
    annotationProcessor("org.mapstruct:mapstruct-processor")
    annotationProcessor("org.projectlombok:lombok")
    annotationProcessor("org.hibernate.orm:hibernate-jpamodelgen")
    // test
    annotationProcessor("org.projectlombok:lombok-mapstruct-binding")
    annotationProcessor("org.mapstruct:mapstruct-processor")
    annotationProcessor("org.projectlombok:lombok")
    annotationProcessor("org.hibernate.orm:hibernate-jpamodelgen")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.springframework.security:spring-security-test")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

group = "cc.elvea.boot"
version = "0.0.1"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

graalvmNative {
    toolchainDetection.set(true)
    metadataRepository {
        version = "0.3.14"
    }
    binaries {
        named("main") {
            buildArgs.add("--initialize-at-build-time=org.slf4j")
            buildArgs.add("--initialize-at-build-time=ch.qos.logback")
            buildArgs.add("--initialize-at-run-time=sun.net.dns.ResolverConfigurationImpl")
            buildArgs.add("--trace-class-initialization=org.springframework.util.ClassUtils")
            buildArgs.add("-H:+ReportExceptionStackTraces")
            buildArgs.add("-H:+PrintClassInitialization")
        }
        metadataRepository {
            enabled.set(true)
        }
    }
}

configurations.forEach {
    it.exclude(module = "bcpkix-jdk15on")
    it.exclude(module = "bcprov-jdk15on")
    it.exclude(module = "bcutil-jdk15on")
}

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
}

tasks.withType<Jar> {
    exclude("application.yml")
    exclude("application-*.yml")
}

tasks.withType<Test> {
    useJUnitPlatform()
}

tasks.named<BootJar>("bootJar") {
    duplicatesStrategy = DuplicatesStrategy.EXCLUDE
}
