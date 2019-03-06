package ru.capjack.tool.kt.utils.random

import ru.capjack.tool.kt.utils.Supplier
import kotlin.random.Random

class RandomValueByWeightSupplier<T>(
	private val values: Array<T>,
	private val weights: IntArray
) : Supplier<T> {
	
	private val totalWeight = weights.sum()
	
	override fun get(): T {
		val r = Random.nextInt(totalWeight)
		var a = 0
		var i = 0
		
		while (true) {
			a += weights[i]
			if (a > r) {
				return values[i]
			}
			++i
		}
	}
}