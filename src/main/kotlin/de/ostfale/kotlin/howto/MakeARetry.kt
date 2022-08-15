package de.ostfale.kotlin.howto

// https://betterprogramming.pub/kotlin-retry-to-make-your-code-more-resilient-5b8cc4fac4e4
inline fun <T> executeWithRetry(
    predicate: (cause: Throwable) -> Boolean = { true },
    retries: Int = 1,
    call: () -> T
): T? {
    for (i in 0..retries) {
        return try {
            call()
        } catch (e: Exception) {
            if (predicate(e) && i < retries) {
                continue
            } else throw e
        }
    }
    return null
}
