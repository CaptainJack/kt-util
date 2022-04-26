package ru.capjack.tool.lang

fun <E> MutableCollection<E>.add(vararg elements: E) {
	addAll(elements)
}