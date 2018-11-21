package ru.capjack.kt.utils.collections

import ru.capjack.kt.utils.Cancelable

fun <E> MutableCollection<in E>.addAsCancelable(element: E): Cancelable {
	add(element)
	return Cancelable { remove(element) }
}

fun <E> MutableCollection<in E>.addAsCancelable(vararg elements: E): Cancelable {
	addAll(elements)
	return Cancelable { removeAll(elements) }
}

fun <E> MutableCollection<in E>.addAsCancelable(elements: Collection<E>): Cancelable {
	addAll(elements)
	return Cancelable { removeAll(elements) }
}


inline fun <T> Iterable<T>.sumByLong(selector: (T) -> Long): Long {
	var sum = 0L
	for (element in this) sum += selector(element)
	return sum
}

fun <T> MutableCollection<T>.set(elements: Collection<T>) {
	clear()
	addAll(elements)
}

fun MutableCollection<Int>.set(elements: IntArray) {
	clear()
	for (element in elements) {
		add(element)
	}
}

expect fun IntArray.set(elements: IntArray)

fun IntArray.set(elements: Array<Int>) {
	set(elements.toIntArray())
}

fun IntArray.set(elements: List<Int>) {
	set(elements.toIntArray())
}