package ru.capjack.tool.lang

expect fun Byte.toHexString(): String
expect fun Byte.toHexString(target: Appendable)

expect fun Int.toHexString(): String
expect fun Int.toHexString(target: Appendable)


fun ByteArray.toHexString(): String {
	if (size == 0) {
		return ""
	}
	val chars = StringBuilder(size * 2)
	repeat(size) { i ->
		this[i].toHexString(chars)
	}
	return chars.toString()
}

fun ByteArray.toHexString(separator: Char): String {
	if (size == 0) {
		return ""
	}
	val chars = StringBuilder(size * 3 - 1)
	repeat(size) { i ->
		if (i != 0) {
			chars.append(separator)
		}
		this[i].toHexString(chars)
	}
	return chars.toString()
}
