package ru.capjack.kt.utils

// apply

inline fun <T> T.applyIf(predicate: Boolean, block: T.() -> Unit): T {
	if (predicate) block()
	return this
}

inline fun <T> T.applyIf(predicate: (T) -> Boolean, block: T.() -> Unit) = applyIf(predicate(this), block)
inline fun <T> T.applyIf(value: T, block: T.() -> Unit) = applyIf(this == value, block)

inline fun <T> T.applyUnless(predicate: Boolean, block: T.() -> Unit) = applyIf(!predicate, block)
inline fun <T> T.applyUnless(predicate: (T) -> Boolean, block: T.() -> Unit) = applyIf(!predicate(this), block)
inline fun <T> T.applyUnless(value: T, block: T.() -> Unit) = applyIf(this != value, block)


// also

inline fun <T> T.alsoIf(predicate: Boolean, block: (T) -> Unit): T {
	if (predicate) block(this)
	return this
}

inline fun <T> T.alsoIf(predicate: (T) -> Boolean, block: (T) -> Unit) = alsoIf(predicate(this), block)
inline fun <T> T.alsoIf(value: T, block: (T) -> Unit) = alsoIf(this == value, block)

inline fun <T> T.alsoUnless(predicate: Boolean, block: (T) -> Unit) = alsoIf(!predicate, block)
inline fun <T> T.alsoUnless(predicate: (T) -> Boolean, block: (T) -> Unit) = alsoIf(!predicate(this), block)
inline fun <T> T.alsoUnless(value: T, block: (T) -> Unit) = alsoIf(this != value, block)


// lets

inline fun <T> T.letIf(predicate: Boolean, block: (T) -> T): T {
	return if (predicate) block(this) else this
}

inline fun <T> T.letIf(predicate: (T) -> Boolean, block: (T) -> T) = letIf(predicate(this), block)
inline fun <T> T.letIf(value: T, block: (T) -> T) = letIf(this == value, block)

inline fun <T> T.letUnless(predicate: Boolean, block: (T) -> T) = letIf(!predicate, block)
inline fun <T> T.letUnless(predicate: (T) -> Boolean, block: (T) -> T) = letIf(!predicate(this), block)
inline fun <T> T.letUnless(value: T, block: (T) -> T) = letIf(this != value, block)


// run

inline fun <T> T.runIf(predicate: Boolean, block: T.() -> T): T {
	return if (predicate) block() else this
}

inline fun <T> T.runIf(predicate: (T) -> Boolean, block: T.() -> T) = runIf(predicate(this), block)
inline fun <T> T.runIf(value: T, block: T.() -> T) = runIf(this == value, block)

inline fun <T> T.runUnless(predicate: Boolean, block: T.() -> T) = runIf(!predicate, block)
inline fun <T> T.runUnless(predicate: (T) -> Boolean, block: T.() -> T) = runIf(!predicate(this), block)
inline fun <T> T.runUnless(value: T, block: T.() -> T) = runIf(this != value, block)
