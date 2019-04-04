package ru.capjack.tool.lang

inline fun <T> Iterable<T>.sumByLong(selector: (T) -> Long): Long {
	var sum = 0L
	for (element in this) sum += selector(element)
	return sum
}

