package ru.capjack.tool.lang

import kotlin.jvm.JvmStatic

open class OutOfMemoryError(message: String?) : Error(message) {
	constructor() : this(null)
}