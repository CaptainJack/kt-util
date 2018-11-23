package ru.capjack.kt.utils


inline fun <T> T.applyIf(value: T, block: T.() -> Unit): T {
	if (this == value) block(this)
	return this
}

inline fun <T> T.applyIf(predicate: (T) -> Boolean, block: T.() -> Unit): T {
	if (predicate(this)) block(this)
	return this
}

inline fun <T> T.applyUnless(value: T, block: T.() -> Unit): T {
	if (this != value) block(this)
	return this
}

inline fun <T> T.applyUnless(predicate: (T) -> Boolean, block: T.() -> Unit): T {
	if (!predicate(this)) block(this)
	return this
}


inline fun <T> T.alsoIf(value: T, block: (T) -> Unit): T {
	if (this == value) block(this)
	return this
}

inline fun <T> T.alsoIf(predicate: (T) -> Boolean, block: (T) -> Unit): T {
	if (predicate(this)) block(this)
	return this
}

inline fun <T> T.alsoUnless(value: T, block: (T) -> Unit): T {
	if (this != value) block(this)
	return this
}

inline fun <T> T.alsoUnless(predicate: (T) -> Boolean, block: (T) -> Unit): T {
	if (!predicate(this)) block(this)
	return this
}


inline fun <T> T.letIf(value: T, block: (T) -> T): T {
	return if (this == value) block(this) else this
}

inline fun <T> T.letIf(predicate: (T) -> Boolean, block: (T) -> T): T {
	return if (predicate(this)) block(this) else this
}

inline fun <T> T.letUnless(value: T, block: (T) -> T): T {
	return if (this != value) block(this) else this
}

inline fun <T> T.letUnless(predicate: (T) -> Boolean, block: (T) -> T): T {
	return if (!predicate(this)) block(this) else this
}


inline fun <T> T.runIf(value: T, block: T.() -> T): T {
	return if (this == value) block(this) else this
}

inline fun <T> T.runIf(predicate: (T) -> Boolean, block: T.() -> T): T {
	return if (predicate(this)) block(this) else this
}

inline fun <T> T.runUnless(value: T, block: T.() -> T): T {
	return if (this != value) block(this) else this
}

inline fun <T> T.runUnless(predicate: (T) -> Boolean, block: T.() -> T): T {
	return if (!predicate(this)) block(this) else this
}