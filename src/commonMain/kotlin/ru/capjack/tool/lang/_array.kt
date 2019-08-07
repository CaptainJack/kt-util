package ru.capjack.tool.lang

val EMPTY_BYTE_ARRAY = ByteArray(0)
val EMPTY_INT_ARRAY = IntArray(0)

expect fun <T> Array<T>.fill(element: T, fromIndex: Int = 0, toIndex: Int = size)
expect fun ByteArray.fill(element: Byte, fromIndex: Int = 0, toIndex: Int = size)
expect fun ShortArray.fill(element: Short, fromIndex: Int = 0, toIndex: Int = size)
expect fun IntArray.fill(element: Int, fromIndex: Int = 0, toIndex: Int = size)
expect fun LongArray.fill(element: Long, fromIndex: Int = 0, toIndex: Int = size)
expect fun FloatArray.fill(element: Float, fromIndex: Int = 0, toIndex: Int = size)
expect fun DoubleArray.fill(element: Double, fromIndex: Int = 0, toIndex: Int = size)
expect fun BooleanArray.fill(element: Boolean, fromIndex: Int = 0, toIndex: Int = size)
expect fun CharArray.fill(element: Char, fromIndex: Int = 0, toIndex: Int = size)
