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


inline fun letTrue(predicate: Boolean, block: () -> Boolean): Boolean {
	return if (predicate) block() else false
}

inline fun letFalse(predicate: Boolean, block: () -> Boolean): Boolean {
	return if (predicate) true else block()
}

@JvmName("letTrueExt")
inline infix fun Boolean.letTrue(block: () -> Boolean) = letTrue(this, block)

@JvmName("letFalseExt")
inline infix fun Boolean.letFalse(block: () -> Boolean) = letFalse(this, block)


inline fun alsoTrue(predicate: Boolean, block: () -> Unit): Boolean {
	if (predicate) block()
	return predicate
}

inline fun alsoFalse(predicate: Boolean, block: () -> Unit): Boolean {
	if (!predicate) block()
	return predicate
}

@JvmName("alsoTrueExt")
inline infix fun Boolean.alsoTrue(block: () -> Unit) = alsoTrue(this, block)

@JvmName("alsoFalseExt")
inline infix fun Boolean.alsoFalse(block: () -> Unit) = alsoFalse(this, block)


@Suppress("NOTHING_TO_INLINE")
inline fun <T> Boolean.make(onTrue: T, onFalse: T) = if (this) onTrue else onFalse

inline fun <T> Boolean.make(onTrue: () -> T, onFalse: () -> T) = if (this) onTrue() else onFalse()