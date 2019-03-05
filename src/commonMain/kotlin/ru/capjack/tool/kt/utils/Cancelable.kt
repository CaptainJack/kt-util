package ru.capjack.tool.kt.utils

import kotlin.jvm.JvmStatic

interface Cancelable {
	fun cancel()
	
	companion object {
		@JvmStatic
		val FAKE = object : Cancelable {
			override fun cancel() {
			}
		}
		
		@JvmStatic
		operator fun invoke(block: () -> Unit): Cancelable {
			return object : Cancelable {
				override fun cancel() = block.invoke()
			}
		}
	}
}