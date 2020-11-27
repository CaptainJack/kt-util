package ru.capjack.tool.lang

inline fun waitUntil(maxTimeoutMillis: Int, checkTimeoutMillis: Int = 10, condition: () -> Boolean) =
	condition().letElse { waitUntilLater(maxTimeoutMillis, checkTimeoutMillis, condition) }

inline fun waitUntilLater(maxTimeoutMillis: Int, checkTimeoutMillis: Int = 10, condition: () -> Boolean) =
	waitForLater(maxTimeoutMillis, checkTimeoutMillis, true, condition)

inline fun waitIf(maxTimeoutMillis: Int, checkTimeoutMillis: Int = 10, condition: () -> Boolean) =
	condition().letIf { waitIfLater(maxTimeoutMillis, checkTimeoutMillis, condition) }

inline fun waitIfLater(maxTimeoutMillis: Int, checkTimeoutMillis: Int = 10, condition: () -> Boolean) =
	waitForLater(maxTimeoutMillis, checkTimeoutMillis, false, condition)


inline fun waitForLater(maxTimeoutMillis: Int, checkTimeoutMillis: Int = 10, expected: Boolean, condition: () -> Boolean): Boolean {
	var result: Boolean
	val checkTime = checkTimeoutMillis.toLong()
	val maxTime = maxTimeoutMillis.toLong()
	val startTime = System.currentTimeMillis()
	do {
		Thread.sleep(checkTime)
		result = condition()
	}
	while (result != expected && System.currentTimeMillis() - startTime < maxTime)
	return result
}