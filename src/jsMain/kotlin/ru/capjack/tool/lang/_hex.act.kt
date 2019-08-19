package ru.capjack.tool.lang

private val HEX_CHARS = arrayOf("0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F")

actual fun Byte.toHexString(): String {
	val v = this.toInt().and(0xFF)
	return HEX_CHARS[v ushr 4] + HEX_CHARS[v and 0x0F]
}

actual fun Byte.toHexString(target: Appendable) {
	val v = this.toInt().and(0xFF)
	target.append(HEX_CHARS[v ushr 4])
	target.append(HEX_CHARS[v and 0x0F])
}

actual fun Int.toHexString(): String {
	return HEX_CHARS[this ushr 28] +
		HEX_CHARS[this ushr 24 and 0x0F] +
		HEX_CHARS[this ushr 20 and 0x0F] +
		HEX_CHARS[this ushr 16 and 0x0F] +
		HEX_CHARS[this ushr 12 and 0x0F] +
		HEX_CHARS[this ushr 8 and 0x0F] +
		HEX_CHARS[this ushr 4 and 0x0F] +
		HEX_CHARS[this and 0x0F]
}

actual fun Int.toHexString(target: Appendable) {
	target.append(HEX_CHARS[this ushr 28])
	target.append(HEX_CHARS[this ushr 24 and 0x0F])
	target.append(HEX_CHARS[this ushr 20 and 0x0F])
	target.append(HEX_CHARS[this ushr 16 and 0x0F])
	target.append(HEX_CHARS[this ushr 12 and 0x0F])
	target.append(HEX_CHARS[this ushr 8 and 0x0F])
	target.append(HEX_CHARS[this ushr 4 and 0x0F])
	target.append(HEX_CHARS[this and 0x0F])
}
