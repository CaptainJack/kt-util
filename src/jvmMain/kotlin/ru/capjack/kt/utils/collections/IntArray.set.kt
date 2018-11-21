package ru.capjack.kt.utils.collections

actual fun IntArray.set(elements: IntArray) {
	System.arraycopy(elements, 0, this, 0, elements.size)
}