package de.ostfale.kotlin.pattern.factory

/**
 * With private constructor only the static factory method is available
 */
class Server private constructor(port: Long) {
    init {
        println("Server started on port: $port")
    }

    companion object {
        fun withPort(port: Long) = Server(port)
    }
}

fun main() {
    Server.withPort(8080)
}

