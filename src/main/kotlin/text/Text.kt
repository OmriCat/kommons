package text

fun CharSequence.words(): List<String> =
  split("\\s".toRegex())
