package ru.capjack.tool.lang

fun Int.match(other: Int): Boolean {
	return and(other) == other
}
