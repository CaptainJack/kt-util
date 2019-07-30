package ru.capjack.tool.lang

fun asThrowable(e: dynamic): Throwable {
	return e as? Throwable ?: ErrorException(e)
}

val Throwable.stackTrace: String
	get() {
		try {
			val string = toString()
			val stack = extractStackTraceList()
			
			var result = string + stack.asStackTrace()
			
			var c = cause
			while (c != null) {
				var s = c.extractStackTraceList()
				var i = s.lastIndex
				var q = stack.lastIndex
				var o = false
				
				while (i >= 0 && q >= 0) {
					if (o) {
						if (stack[q] == s[i]) {
							--i
						}
						else {
							break
						}
					}
					else {
						if (stack[q] == s[i]) {
							--i
							o = true
						}
					}
					--q
				}
				
				if (i != s.lastIndex) {
					s = s.subList(0, i + 1) + "... ${s.lastIndex - i} more"
				}
				
				result += "\nCaused by: " + c.toString() + s.asStackTrace()
				
				c = c.cause
			}
			
			return result
		}
		catch (e: dynamic) {
			return "Failed to retrieve stack trace string ($e)"
		}
	}

private val browserHasNormalStackTrace = js("!!Error.captureStackTrace").unsafeCast<Boolean>()

private fun List<String>.asStackTrace(): String {
	return ifEmpty { listOf("<no stack trace>") }.joinToString("\n\t", "\n\t", transform = String::trim)
}

private fun Throwable.extractStackTraceList(): List<String> {
	
	var skip = !browserHasNormalStackTrace
	val name = if (skip) this.asDynamic().name.unsafeCast<String?>() else null
	
	return (asDynamic().stack as String?)?.run {
		lines().mapIndexedNotNull { i, s ->
			val line = s.trim()
			
			if (line.isEmpty() || (browserHasNormalStackTrace && i == 0)) {
				null
			}
			else if (!browserHasNormalStackTrace) {
				when (val a = line.indexOf('@')) {
					-1   -> "at $line"
					0    -> "at ${line.substring(1)}"
					else -> {
						if (skip) {
							if (line.substring(0, a) == name) skip = false
							null
						}
						else "at ${line.substring(0, a)} (${line.substring(a + 1)})"
					}
				}
			}
			else {
				line
			}
			
		}.toList()
	}.orEmpty()
}
