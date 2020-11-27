package ru.capjack.tool.lang

import kotlin.jvm.JvmName

inline fun <T> T.applyOn(value: T, block: T.() -> Unit): T {
	if (this == value) block()
	return this
}

inline fun <T> T.applyEx(value: T, block: T.() -> Unit): T {
	if (this != value) block()
	return this
}


inline fun <T> T.alsoOn(value: T, block: (T) -> Unit): T {
	if (this == value) block(this)
	return this
}

inline fun <T> T.alsoEx(value: T, block: (T) -> Unit): T {
	if (this != value) block(this)
	return this
}


inline fun <T> T.letOn(value: T, block: (T) -> T): T {
	return if (this == value) block(this) else this
}

inline fun <T> T.letEx(value: T, block: (T) -> T): T {
	return if (this != value) block(this) else this
}


inline fun <T> T.runOn(value: T, block: T.() -> T): T {
	return if (this == value) block() else this
}

inline fun <T> T.runEx(value: T, block: T.() -> T): T {
	return if (this != value) block() else this
}


@JvmName("letOnBoolean")
inline fun letOn(predicate: Boolean, block: () -> Boolean): Boolean {
	return if (predicate) block() else false
}

@JvmName("letExBoolean")
inline fun letEx(predicate: Boolean, block: () -> Boolean): Boolean {
	return if (predicate) true else block()
}

inline infix fun Boolean.letOn(block: () -> Boolean) = letOn(this, block)

inline infix fun Boolean.letEx(block: () -> Boolean) = letEx(this, block)


@JvmName("alsoOnBoolean")
inline fun alsoOn(predicate: Boolean, block: () -> Unit): Boolean {
	if (predicate) block()
	return predicate
}

@JvmName("alsoExBoolean")
inline fun alsoEx(predicate: Boolean, block: () -> Unit): Boolean {
	if (!predicate) block()
	return predicate
}

inline infix fun Boolean.alsoOn(block: () -> Unit) = alsoOn(this, block)

inline infix fun Boolean.alsoEx(block: () -> Unit) = alsoEx(this, block)


@Suppress("NOTHING_TO_INLINE")
inline fun <T> Boolean.make(onTrue: T, onFalse: T) = if (this) onTrue else onFalse
