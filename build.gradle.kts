import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

buildscript {
  repositories {
    mavenCentral()
    jcenter()
  }
  dependencies {
    classpath(Deps.Kotlin.gradlePlugin)
  }
}

plugins {
  kotlin("jvm") version Versions.kotlin
  id(Deps.Build.Nebula.resolutionRules) version Versions.Build.Nebula.resolutionRules
  `maven-publish`
}

repositories {
  mavenCentral()
}

dependencies {
  implementation(kotlin("stdlib"))
  resolutionRules("com.netflix.nebula:gradle-resolution-rules:0.52.0")
}

group = "com.omricat"
version = "0.3.2"

tasks.withType<KotlinCompile> {
  kotlinOptions.jvmTarget = "1.6"
}

repositories {
  mavenCentral()
  jcenter()
  maven("https://jitpack.io")
}


val sourcesJar by tasks.creating(Jar::class) {
  dependsOn(JavaPlugin.CLASSES_TASK_NAME)
  classifier = "sources"
  from(java.sourceSets["main"].allSource)
}

val javadocJar by tasks.creating(Jar::class) {
  dependsOn(JavaPlugin.JAVADOC_TASK_NAME)
  classifier = "javadoc"
  from(java.docsDir)
}


publishing {
  (publications) {
    "mavenJava".invoke(MavenPublication::class) {
      from(components["java"])
      artifact(sourcesJar)
      artifact(javadocJar)
    }
  }
}
