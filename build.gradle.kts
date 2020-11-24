import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

group = "com.omricat"
version = "0.5"

plugins {
  kotlin("jvm")

  `maven-publish`
}

repositories {
  mavenCentral()
  jcenter()
  maven("https://jitpack.io")
}

dependencies {
  implementation(Kotlin.stdlib)

  testImplementation(Testing.kotest.runner.junit5)
  testImplementation(Testing.kotest.assertions.core)
}

tasks {
  withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
  }

  withType<Test> {
    useJUnitPlatform()
  }
}
