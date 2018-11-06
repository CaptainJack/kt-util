package ru.capjack.kt.utils.collections

import java.util.concurrent.CopyOnWriteArrayList

actual class ConcurrentList<E> : CopyOnWriteArrayList<E>(), MutableList<E>
