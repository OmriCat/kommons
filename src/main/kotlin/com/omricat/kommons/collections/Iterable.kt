package com.omricat.kommons.collections

/**
 * Returns `true` if this [Iterable] contains an element satisfying the given predicate
 *
 * @param predicate the predicate which tests elements of this iterable
 */
inline fun <T> Iterable<T>.containsBy(predicate: (T) -> Boolean ): Boolean =
  firstOrNull(predicate) != null
