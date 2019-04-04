package ru.capjack.tool.lang

inline fun <T> jso(init: T.() -> Unit): T {
	return js("{}").unsafeCast<T>().apply(init)
}

private val EMPTY_FUNCTION = js("function(){}")
fun <F : Function<*>> emptyFunction(): F = EMPTY_FUNCTION.unsafeCast<F>()