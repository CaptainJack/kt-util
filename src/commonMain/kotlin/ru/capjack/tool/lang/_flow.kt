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


inline fun letIf(predicate: Boolean, block: () -> Boolean): Boolean {
	return if (predicate) block() else false
}

inline fun letElse(predicate: Boolean, block: () -> Boolean): Boolean {
	return if (predicate) true else block()
}
@JvmName("letIfExt")
inline infix fun Boolean.letIf(block: () -> Boolean) = letIf(this, block)

@JvmName("letElseExt")
inline infix fun Boolean.letElse(block: () -> Boolean) = letElse(this, block)


inline fun alsoIf(predicate: Boolean, block: () -> Unit): Boolean {
	if (predicate) block()
	return predicate
}

inline fun alsoElse(predicate: Boolean, block: () -> Unit): Boolean {
	if (!predicate) block()
	return predicate
}

@JvmName("alsoIfExt")
inline infix fun Boolean.alsoIf(block: () -> Unit) = alsoIf(this, block)

@JvmName("alsoElseExt")
inline infix fun Boolean.alsoElse(block: () -> Unit) = alsoElse(this, block)


@Suppress("NOTHING_TO_INLINE")
inline fun <T> Boolean.make(onTrue: T, onFalse: T) = if (this) onTrue else onFalse
