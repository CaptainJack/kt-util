package ru.capjack.tool.lang

private val hexArray = charArrayOf('0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F')

fun Byte.toHexString(): String {
	return String(CharArray(2).also { toHexString(it, 0) })
}

fun ByteArray.toHexString(): String {
	if (size == 0) {
		return ""
	}
	val chars = CharArray(size * 2)
	repeat(size) { i ->
		this[i].toHexString(chars, i * 2)
	}
	return String(chars)
}

fun ByteArray.toHexString(separator: Char): String {
	if (size == 0) {
		return ""
	}
	val chars = CharArray(size * 3 - 1)
	repeat(size) { i ->
		val o = i * 3
		if (i != 0) {
			chars[o - 1] = separator
		}
		this[i].toHexString(chars, o)
	}
	return String(chars)
}

fun Byte.toHexString(chars: CharArray, offset: Int) {
	val v = this.toInt().and(0xFF)
	chars[offset] = hexArray[v ushr 4]
	chars[offset + 1] = hexArray[v and 0x0F]
}

fun Byte.toHexString(string: StringBuilder) {
	val v = this.toInt().and(0xFF)
	string.append(hexArray[v ushr 4])
	string.append(hexArray[v and 0x0F])
}
