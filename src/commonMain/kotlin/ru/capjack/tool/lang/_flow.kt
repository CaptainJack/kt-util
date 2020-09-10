package ru.capjack.tool.lang

import kotlin.jvm.JvmName

inline fun <T> T.applyFor(value: T, block: T.() -> Unit): T {
	if (this == value) block()
	return this
}

inline fun <T> T.applyExcept(value: T, block: T.() -> Unit): T {
	if (this != value) block()
	return this
}


inline fun <T> T.alsoFor(value: T, block: (T) -> Unit): T {
	if (this == value) block(this)
	return this
}

inline fun <T> T.alsoExcept(value: T, block: (T) -> Unit): T {
	if (this != value) block(this)
	return this
}


inline fun <T> T.letFor(value: T, block: (T) -> T): T {
	return if (this == value) block(this) else this
}

inline fun <T> T.letExcept(value: T, block: (T) -> T): T {
	return if (this != value) block(this) else this
}


inline fun <T> T.runFor(value: T, block: T.() -> T): T {
	return if (this == value) block() else this
}

inline fun <T> T.runExcept(value: T, block: T.() -> T): T {
	return if (this != value) block() else this
}


inline infix fun Boolean.lefTrue(block: () -> Boolean): Boolean {
	return if (this) block() else false
}

inline infix fun Boolean.lefFalse(block: () -> Boolean): Boolean {
	return if (this) true else block()
}

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
