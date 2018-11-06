package ru.capjack.kt.utils

import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

object Delegates {
	fun <T> observableChange(value: T, onChange: (T) -> Unit): ReadWriteProperty<Any?, T> {
		return ChangeObservableProperty(value, onChange)
	}
	
	fun <T> observableChange(value: T, onChange: () -> Unit): ReadWriteProperty<Any?, T> {
		return ChangeObservableProperty(value) { onChange() }
	}
	
	private class ChangeObservableProperty<T>(
		private var value: T,
		private var handler: (T) -> Unit
	) : ReadWriteProperty<Any?, T> {
		
		override fun getValue(thisRef: Any?, property: KProperty<*>): T {
			return value
		}
		
		override fun setValue(thisRef: Any?, property: KProperty<*>, value: T) {
			if (this.value != value) {
				this.value = value
				handler(value)
			}
		}
	}
}
