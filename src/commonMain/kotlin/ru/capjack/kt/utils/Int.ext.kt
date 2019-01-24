package ru.capjack.kt.utils

fun Int.hasBits(bits: Int) : Boolean {
	return and(bits) == bits
}
