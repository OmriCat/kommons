package com.omricat.kommons.math

import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.style.ShouldSpec
import io.kotest.data.Table3
import io.kotest.data.forAll
import io.kotest.data.headers
import io.kotest.data.row
import io.kotest.data.table
import io.kotest.inspectors.forAll
import io.kotest.matchers.Matcher
import io.kotest.matchers.comparables.lt
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe

internal class NumberTest : ShouldSpec() {
   init {
      val negative: Matcher<Int> = lt(0)
      val intValues = listOf(Int.MAX_VALUE, Int.MIN_VALUE, -100, 0, 33)
      val intNonNegativeTable: Table3<Int, Int, Int> = table(
            headers("Value", "Modulus", "Result"),
            row(0, 1, 0),
            row(-50, 31, 12),
            row(20, 17, 3)
      )

      context("Int.leastNonNegativeResidue") {
         should("never return negative") {
            intValues.forAll {
               it.leastNonNegativeResidue(17) shouldNotBe negative
            }

            forAll { value: Int ->
               value.leastNonNegativeResidue(17) >= 0
            }
         }

         should("throw IAE for non-negative modulus") {
            intValues.filter { it <= 0 }.forAll{ modulus ->
               shouldThrowExactly<IllegalArgumentException> {
                  33.leastNonNegativeResidue(modulus)
               }
            }
         }

         should("return expected values for particular inputs") {
            intNonNegativeTable.forAll { value, modulus, result ->
               value.leastNonNegativeResidue(modulus) shouldBe result
            }
         }
      }
   }
}
