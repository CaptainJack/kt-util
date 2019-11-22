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
	var s = ""
	for (i in 7 downTo 0) {
		s += HEX_CHARS[this ushr (i * 4) and 0x0F]
	}
	return s
}

actual fun Int.toHexString(target: Appendable) {
	for (i in 7 downTo 0) {
		target.append(HEX_CHARS[this ushr (i * 4) and 0x0F])
	}
}


actual fun Long.toHexString(): String {
	var s = ""
	for (i in 15 downTo 0) {
		s += HEX_CHARS[(this ushr (i * 4)).toInt() and 0x0F]
	}
	return s
}

actual fun Long.toHexString(target: Appendable) {
	for (i in 15 downTo 0) {
		target.append(HEX_CHARS[(this ushr (i * 4)).toInt() and 0x0F])
	}
}