package ru.capjack.tool.lang

@Suppress("NOTHING_TO_INLINE")
inline fun <T> T?.unsafeNotNull(): T {
	return unsafeCast<T>()
}