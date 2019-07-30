package ru.capjack.tool.lang

import ru.capjack.tool.lang.lefIf

inline fun waitIf(maxTimeoutMillis: Long, checkTimeoutMillis: Long = 10, check: () -> Boolean): Boolean {
	return lefIf(check()) {
		waitIfImmediately(maxTimeoutMillis, checkTimeoutMillis, check)
	}
}

inline fun waitIfImmediately(maxTimeoutMillis: Long, checkTimeoutMillis: Long = 10, check: () -> Boolean): Boolean {
	var b: Boolean
	val time = System.currentTimeMillis()
	do {
		Thread.sleep(checkTimeoutMillis)
		b = check()
	}
	while (b && System.currentTimeMillis() - time < maxTimeoutMillis)
	return b
}