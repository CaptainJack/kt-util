package ru.capjack.tool.lang

private val HEX_CHARS = charArrayOf('0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F')

actual fun Byte.toHexString(): String {
	return String(CharArray(2).also { toHexString(it, 0) })
}

actual fun Byte.toHexString(target: Appendable) {
	val v = this.toInt().and(0xFF)
	target.append(HEX_CHARS[v ushr 4])
	target.append(HEX_CHARS[v and 0x0F])
}

fun Byte.toHexString(chars: CharArray, offset: Int) {
	val v = this.toInt().and(0xFF)
	chars[offset] = HEX_CHARS[v ushr 4]
	chars[offset + 1] = HEX_CHARS[v and 0x0F]
}


actual fun Int.toHexString(): String {
	return String(CharArray(8).also { toHexString(it, 0) })
}

actual fun Int.toHexString(target: Appendable) {
	for (i in 7 downTo 0) {
		target.append(HEX_CHARS[this ushr (i * 4) and 0x0F])
	}
}

fun Int.toHexString(chars: CharArray, offset: Int) {
	repeat(8) {
		chars[offset + it] = HEX_CHARS[this ushr ((7 - it) * 4) and 0x0F]
	}
}


actual fun Long.toHexString(): String {
	return String(CharArray(16).also { toHexString(it, 0) })
}

actual fun Long.toHexString(target: Appendable) {
	for (i in 15 downTo 0) {
		target.append(HEX_CHARS[(this ushr (i * 4)).toInt() and 0x0F])
	}
}

fun Long.toHexString(chars: CharArray, offset: Int) {
	repeat(16) {
		chars[offset + it] = HEX_CHARS[(this ushr ((15 - it) * 4)).toInt() and 0x0F]
	}
}