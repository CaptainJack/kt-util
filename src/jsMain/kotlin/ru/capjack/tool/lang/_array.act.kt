package ru.capjack.tool.lang

actual fun <T> Array<T>.fill(element: T, fromIndex: Int, toIndex: Int) = fillArray(this, element, size, fromIndex, toIndex)
actual fun ByteArray.fill(element: Byte, fromIndex: Int, toIndex: Int) = fillArray(this, element, size, fromIndex, toIndex)
actual fun ShortArray.fill(element: Short, fromIndex: Int, toIndex: Int) = fillArray(this, element, size, fromIndex, toIndex)
actual fun IntArray.fill(element: Int, fromIndex: Int, toIndex: Int) = fillArray(this, element, size, fromIndex, toIndex)
actual fun LongArray.fill(element: Long, fromIndex: Int, toIndex: Int) = fillArray(this, element, size, fromIndex, toIndex)
actual fun FloatArray.fill(element: Float, fromIndex: Int, toIndex: Int) = fillArray(this, element, size, fromIndex, toIndex)
actual fun DoubleArray.fill(element: Double, fromIndex: Int, toIndex: Int) = fillArray(this, element, size, fromIndex, toIndex)
actual fun BooleanArray.fill(element: Boolean, fromIndex: Int, toIndex: Int) = fillArray(this, element, size, fromIndex, toIndex)
actual fun CharArray.fill(element: Char, fromIndex: Int, toIndex: Int) = fillArray(this, element, size, fromIndex, toIndex)

private fun fillArray(a: dynamic, e: dynamic, s: Int, f: Int, t: Int) {
	if (f > t) throw IllegalArgumentException("fromIndex($f) > toIndex($t)")
	if (f < 0) throw IndexOutOfBoundsException("fromIndex($f) < 0")
	if (t > s) throw IndexOutOfBoundsException("toIndex($t) > size($s)")
	for (i in f until t) a[i] = e
}
