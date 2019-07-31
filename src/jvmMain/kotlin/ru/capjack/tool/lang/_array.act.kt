@file:Suppress("NOTHING_TO_INLINE")

package ru.capjack.tool.lang

import kotlin.collections.fill as stdlibFill

actual inline fun <T> Array<T>.fill(element: T, fromIndex: Int, toIndex: Int) = stdlibFill(element, fromIndex, toIndex)
actual inline fun ByteArray.fill(element: Byte, fromIndex: Int, toIndex: Int) = stdlibFill(element, fromIndex, toIndex)
actual inline fun ShortArray.fill(element: Short, fromIndex: Int, toIndex: Int) = stdlibFill(element, fromIndex, toIndex)
actual inline fun IntArray.fill(element: Int, fromIndex: Int, toIndex: Int) = stdlibFill(element, fromIndex, toIndex)
actual inline fun LongArray.fill(element: Long, fromIndex: Int, toIndex: Int) = stdlibFill(element, fromIndex, toIndex)
actual inline fun FloatArray.fill(element: Float, fromIndex: Int, toIndex: Int) = stdlibFill(element, fromIndex, toIndex)
actual inline fun DoubleArray.fill(element: Double, fromIndex: Int, toIndex: Int) = stdlibFill(element, fromIndex, toIndex)
actual inline fun BooleanArray.fill(element: Boolean, fromIndex: Int, toIndex: Int) = stdlibFill(element, fromIndex, toIndex)
actual inline fun CharArray.fill(element: Char, fromIndex: Int, toIndex: Int) = stdlibFill(element, fromIndex, toIndex)
