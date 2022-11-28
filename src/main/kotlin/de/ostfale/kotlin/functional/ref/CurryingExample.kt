package de.ostfale.kotlin.functional.ref

enum class LogLevel {
    ERROR, WARNING, INFO
}

// usual log function
fun log(level: LogLevel, message: String) = println("$level: $message")

// specialised function with the need to create all functions ahead of time to be used
val errorLog = fun(message: String) { log(LogLevel.ERROR, message) }

// curried version
fun createLogger(level: LogLevel): (String) -> Unit {
    return { message: String -> log(level, message) }
}

fun main() {
    val infoLogger = createLogger(LogLevel.INFO)
    infoLogger("This is an info message!")
}

