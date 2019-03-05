package ru.capjack.tool.kt.utils

fun Int.hasBits(bits: Int): Boolean {
	return and(bits) == bits
}
