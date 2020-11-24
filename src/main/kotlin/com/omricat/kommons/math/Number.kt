package com.omricat.kommons.math

fun Long.leastNonNegativeResidue(modulus: Long): Long =
    leastResidue(LeastResidueType.NON_NEGATIVE, modulus)

fun Long.leastPositiveResidue(modulus: Long): Long =
    leastResidue(LeastResidueType.POSITIVE, modulus)

fun Int.leastNonNegativeResidue(modulus: Int): Int =
  leastResidue(LeastResidueType.NON_NEGATIVE, modulus)

fun Int.leastPositiveResidue(modulus: Int): Int =
  leastResidue(LeastResidueType.POSITIVE, modulus)

@Suppress("NOTHING_TO_INLINE")
private inline fun Int.leastResidue(type: LeastResidueType, modulus: Int): Int {
  require(modulus > 0) { "Modulus must be positive, was $modulus" }
  val residue = this % modulus
  return if (residue >= type.mustBeAtLeast)
    residue
  else
    residue + modulus
}

@Suppress("NOTHING_TO_INLINE")
private inline fun Long.leastResidue(
  type: LeastResidueType,
  modulus: Long
): Long {
  require(modulus > 0) { "Modulus must be positive, was $modulus" }
  val residue = this % modulus
  return if (residue >= type.mustBeAtLeast)
    residue
  else
    residue + modulus
}

private enum class LeastResidueType(val mustBeAtLeast: Int) { NON_NEGATIVE(0), POSITIVE(1) }


