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
	this.toString(16)
	target.append(HEX_CHARS[this ushr 28])
	target.append(HEX_CHARS[this ushr 24 and 0x0F])
	target.append(HEX_CHARS[this ushr 20 and 0x0F])
	target.append(HEX_CHARS[this ushr 16 and 0x0F])
	target.append(HEX_CHARS[this ushr 12 and 0x0F])
	target.append(HEX_CHARS[this ushr 8 and 0x0F])
	target.append(HEX_CHARS[this ushr 4 and 0x0F])
	target.append(HEX_CHARS[this and 0x0F])
}

fun Int.toHexString(chars: CharArray, offset: Int) {
	chars[offset] = HEX_CHARS[this ushr 28]
	chars[offset + 1] = HEX_CHARS[this ushr 24 and 0x0F]
	chars[offset + 2] = HEX_CHARS[this ushr 20 and 0x0F]
	chars[offset + 3] = HEX_CHARS[this ushr 16 and 0x0F]
	chars[offset + 4] = HEX_CHARS[this ushr 12 and 0x0F]
	chars[offset + 5] = HEX_CHARS[this ushr 8 and 0x0F]
	chars[offset + 6] = HEX_CHARS[this ushr 4 and 0x0F]
	chars[offset + 7] = HEX_CHARS[this and 0x0F]
}