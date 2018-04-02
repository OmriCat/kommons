package com.omricat.kommons

inline fun <T> T.letIf(condition: Boolean, function: (T) -> T): T =
  if (condition) let(function) else this

inline fun <T> T.applyIf(condition: Boolean, block: T.() -> Unit): T =
  if (condition) apply(block) else this
