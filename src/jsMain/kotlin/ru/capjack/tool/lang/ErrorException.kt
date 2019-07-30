package ru.capjack.tool.lang

open class ErrorException(error: dynamic) : RuntimeException(
	error::class.js.name + ": " + (error.message.unsafeCast<String?>() ?: error.toString())
)