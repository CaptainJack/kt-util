package ru.capjack.tool.lang

inline fun waitIf(maxTimeoutMillis: Int, checkTimeoutMillis: Int = 10, check: () -> Boolean): Boolean {
	return lefIf(check()) {
		waitIfImmediately(maxTimeoutMillis, checkTimeoutMillis, check)
	}
}

inline fun waitIfImmediately(maxTimeoutMillis: Int, checkTimeoutMillis: Int = 10, check: () -> Boolean): Boolean {
	var b: Boolean
	val time = System.currentTimeMillis()
	val checkTimeoutMillisLong = checkTimeoutMillis.toLong()
	val maxTimeoutMillisLong = maxTimeoutMillis.toLong()
	do {
		Thread.sleep(checkTimeoutMillisLong)
		b = check()
	}
	while (b && System.currentTimeMillis() - time < maxTimeoutMillisLong)
	return b
}
