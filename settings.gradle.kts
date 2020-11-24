import de.fayard.refreshVersions.bootstrapRefreshVersions

buildscript {
  repositories { gradlePluginPortal() }
  dependencies.classpath("de.fayard.refreshVersions:refreshVersions:0.9.7")
}

plugins {
  id("com.pablisco.gradle.automodule") version "0.15"
}

bootstrapRefreshVersions()
