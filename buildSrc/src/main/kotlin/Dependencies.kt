@file:Suppress("unused")

object Versions {
  const val gradle = "4.6"
  const val kotlin = "1.2.31"

  object Build {
    object Nebula {
      const val resolutionRules = "5.1.1"
    }
  }
}

object Deps {
  object Kotlin {
    const val stdlib = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin}"
    const val gradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
    const val test = "org.jetbrains.kotlin:kotlin-test:${Versions.kotlin}"
    const val reflect = "org.jetbrains.kotlin:kotlin-reflect:${Versions.kotlin}"
  }

  object Build {
    object Nebula {
      const val resolutionRules = "nebula.resolution-rules"
    }
  }
}
