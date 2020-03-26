package ru.capjack.tool.lang

inline fun <T> jso(init: T.() -> Unit): T {
	return js("{}").unsafeCast<T>().apply(init)
}
