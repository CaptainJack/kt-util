package ru.capjack.kt.utils.collections

actual fun IntArray.set(elements: IntArray) {
	repeat(kotlin.math.min(size, elements.size)) {
		this[it] = elements[it]
	}
}