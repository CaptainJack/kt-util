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