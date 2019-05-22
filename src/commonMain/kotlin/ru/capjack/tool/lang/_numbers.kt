@file:Suppress("NOTHING_TO_INLINE")

package ru.capjack.tool.lang

inline fun Int.isZero() = this == 0
inline fun Long.isZero() = this == 0L

inline fun Int.isNotZero() = this != 0
inline fun Long.isNotZero() = this != 0L
