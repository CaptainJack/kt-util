package ru.capjack.tool.lang

infix fun Int.has(bits: Int): Boolean {
	return and(bits) == bits
}

infix fun Long.has(bits: Long): Boolean {
	return and(bits) == bits
}
