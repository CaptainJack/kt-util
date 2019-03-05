package ru.capjack.tool.kt.utils.random

import ru.capjack.tool.kt.utils.Supplier
import kotlin.random.Random

class RandomIntByWeightSupplier(
	private val values: IntArray,
	private val weights: IntArray
) : Supplier<Int> {
	
	private val totalWeight = weights.sum()
	
	override fun get(): Int {
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