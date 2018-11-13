package ru.capjack.kt.utils

inline fun Boolean.onTrue(block: () -> Unit): Boolean {
	if (this) block()
	return this
}

inline fun Boolean.onFalse(block: () -> Unit): Boolean {
	if (!this) block()
	return this
}

inline fun <T> Boolean.letTrue(block: () -> T): T? {
	return if (this) block() else null
}

inline fun <T> Boolean.letFalse(block: () -> T): T? {
	return if (!this) block() else null
}