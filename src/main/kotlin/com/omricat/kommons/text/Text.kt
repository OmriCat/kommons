package com.omricat.kommons.text

fun CharSequence.words(): List<String> =
  split("\\s".toRegex())
