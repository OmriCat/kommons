@file:Suppress("NOTHING_TO_INLINE")

package com.omricat.kommons

/**
 * Returns true if the nullable Boolean receiver is non-null and equal to true.
 */
inline fun Boolean?.isTrue(): Boolean = this == true

/**
 * Returns true if the nullable Boolean receiver is non-null and equal to false.
 *
 * In general, b.isTrue().not() != b.isFalse()
 */
inline fun Boolean?.isFalse(): Boolean = this == false
