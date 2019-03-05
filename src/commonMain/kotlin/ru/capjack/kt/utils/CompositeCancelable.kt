package ru.capjack.kt.utils

open class CompositeCancelable(
	private val list: MutableList<Cancelable> = arrayListOf()
) : Cancelable {
	
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