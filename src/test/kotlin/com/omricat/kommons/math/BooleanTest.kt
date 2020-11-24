package com.omricat.kommons.math

import com.omricat.kommons.isFalse
import com.omricat.kommons.isTrue
import io.kotest.core.spec.style.ShouldSpec
import io.kotest.matchers.booleans.shouldBeFalse
import io.kotest.matchers.booleans.shouldBeTrue

class BooleanTest : ShouldSpec({

   context("Boolean?.isTrue()") {
      should("return false for null") {
         val testValue: Boolean? = null
         testValue.isTrue().shouldBeFalse()
      }

      @Suppress("RedundantNullableReturnType")
      should("return false for false") {
         val testValue: Boolean? = false
         testValue.isTrue().shouldBeFalse()
      }

      @Suppress("RedundantNullableReturnType")
      should("return true for true") {
         val testValue: Boolean? = true
         testValue.isTrue().shouldBeTrue()
      }
   }
   context("Boolean?.isFalse()") {
      should("return false for null") {
         val testValue: Boolean? = null
         testValue.isFalse().shouldBeFalse()
      }

      @Suppress("RedundantNullableReturnType")
      should("return true for false") {
         val testValue: Boolean? = false
         testValue.isFalse().shouldBeTrue()
      }

      @Suppress("RedundantNullableReturnType")
      should("return false for true") {
         val testValue: Boolean? = true
         testValue.isFalse().shouldBeFalse()
      }
   }
})
