package ru.capjack.kt.utils

inline fun Boolean.onTrue(block: () -> Unit): Boolean {
	if (this) block()
	return this
}

inline fun Boolean.onFalse(block: () -> Unit): Boolean {
	if (!this) block()
	return this
}

inline fun Boolean.letTrue(block: () -> Boolean): Boolean {
	return if (this) block() else false
}

inline fun Boolean.letFalse(block: () -> Boolean): Boolean {
	return if (!this) block() else true
}