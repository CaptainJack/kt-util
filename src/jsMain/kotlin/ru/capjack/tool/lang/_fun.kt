@file:Suppress("UnsafeCastFromDynamic")

package ru.capjack.tool.lang

private val EMPTY_FUNCTION = js("function(){}")

actual val EMPTY_FUNCTION_0: () -> Unit = EMPTY_FUNCTION
actual val EMPTY_FUNCTION_1: (Any?) -> Unit = EMPTY_FUNCTION
actual val EMPTY_FUNCTION_2: (Any?, Any?) -> Unit = EMPTY_FUNCTION
actual val EMPTY_FUNCTION_3: (Any?, Any?, Any?) -> Unit = EMPTY_FUNCTION

fun <F : Function<*>> emptyFunction(): F = EMPTY_FUNCTION.unsafeCast<F>()

inline fun <T> jso(init: T.() -> Unit): T {
	return js("{}").unsafeCast<T>().apply(init)
}
