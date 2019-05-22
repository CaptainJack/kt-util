package ru.capjack.tool.lang

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
	return if (this == value) block(this) else this
}

inline fun <T> T.runExcept(value: T, block: T.() -> T): T {
	return if (this != value) block(this) else this
}

inline fun lefIf(predicate: Boolean, block: () -> Boolean): Boolean {
	return if (predicate) block() else predicate
}

inline fun alsoIf(predicate: Boolean, block: () -> Unit): Boolean {
	if (predicate) block()
	return predicate
}

inline infix fun Boolean.orElse(block: () -> Unit): Boolean {
	if (!this) block()
	return this
}