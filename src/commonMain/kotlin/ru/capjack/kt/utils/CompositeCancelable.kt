package ru.capjack.kt.utils

import ru.capjack.kt.utils.collections.ConcurrentList

open class CompositeCancelable(concurrent: Boolean) : Cancelable {
	private val list: MutableList<Cancelable> = if (concurrent) arrayListOf() else ConcurrentList()
	
	fun add(value: Cancelable) {
		list.add(value)
	}
	
	fun add(vararg values: Cancelable) {
		list.addAll(values)
	}
	
	fun add(values: Collection<Cancelable>) {
		list.addAll(values)
	}
	
	override fun cancel() {
		val oldList = list.toList()
		list.removeAll(oldList)
		oldList.forEach(Cancelable::cancel)
	}
}