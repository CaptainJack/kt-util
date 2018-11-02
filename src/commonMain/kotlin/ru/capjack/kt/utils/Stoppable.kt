package ru.capjack.kt.utils

import kotlin.jvm.JvmStatic

interface Stoppable {
	fun stop()
	
	companion object {
		@JvmStatic
		val FAKE = object : Stoppable {
			override fun stop() {
			}
		}
		
		@JvmStatic
		operator fun invoke(block: () -> Unit): Stoppable {
			return object : Stoppable {
				override fun stop() = block.invoke()
			}
		}
	}
}