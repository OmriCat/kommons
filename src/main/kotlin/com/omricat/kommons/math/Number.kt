package com.omricat.kommons.math

fun Long.leastNonNegativeResidue(modulus: Long): Long {
  require(modulus > 0) { "Modulus must be positive, was $modulus" }
  val residue = this % modulus
  return if (residue >= 0)
    residue
  else
    residue + modulus
}

fun Int.leastNonNegativeResidue(modulus: Int): Int {
  require(modulus > 0) { "Modulus must be positive, was $modulus" }
  val residue = this % modulus
  return if (residue >= 0)
    residue
  else
    residue + modulus
}

