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


inline fun lefIf(predicate: Boolean, block: () -> Boolean): Boolean {
	return if (predicate) block() else predicate
}

@JvmName("lefIfExt")
inline fun Boolean.lefIf(block: () -> Boolean): Boolean {
	return if (this) block() else false
}

inline fun Boolean.lefElse(block: () -> Boolean): Boolean {
	return if (!this) block() else false
}


inline fun alsoIf(predicate: Boolean, block: () -> Unit): Boolean {
	if (predicate) block()
	return predicate
}

@JvmName("alsoIfExt")
inline infix fun Boolean.alsoIf(block: () -> Unit): Boolean {
	if (this) block()
	return this
}

inline infix fun Boolean.alsoElse(block: () -> Unit): Boolean {
	if (!this) block()
	return this
}


fun <T> Boolean.make(onTrue: T, onFalse: T): T {
	return if (this) onTrue else onFalse
}