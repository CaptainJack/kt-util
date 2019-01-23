package ru.capjack.kt.utils

import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

object Properties {
	fun <T> observable(value: T, observer: (T) -> Unit): ReadWriteProperty<Any?, T> {
		return ObservableProperty(value, observer)
	}
	
	fun <T> observable(value: T, observer: () -> Unit): ReadWriteProperty<Any?, T> {
		return ObservableProperty(value) { observer() }
	}
	
	class ObservableProperty<T>(
		private var value: T,
		private var observer: (T) -> Unit
	) : ReadWriteProperty<Any?, T> {
		
		override fun getValue(thisRef: Any?, property: KProperty<*>): T {
			return value
		}
		
		override fun setValue(thisRef: Any?, property: KProperty<*>, value: T) {
			if (this.value != value) {
				this.value = value
				observer(value)
			}
		}
	}
}
