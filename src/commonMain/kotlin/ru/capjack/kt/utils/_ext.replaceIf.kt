package ru.capjack.kt.utils

fun <T> T.replaceIf(eq: T, to: T): T {
	return if (this == eq) to else this
}

fun <T> T.replaceIf(condition: Boolean, to: T): T {
	return if (condition) to else this
}

inline fun <T> T.replaceIf(condition: Boolean, to: (T) -> T): T {
	return if (condition) to(this) else this
}

inline fun <T> T.replaceIf(condition: (T) -> Boolean, to: T): T {
	return if (condition(this)) to else this
}

inline fun <T> T.replaceIf(condition: (T) -> Boolean, to: (T) -> T): T {
	return if (condition(this)) to(this) else this
}