package de.ostfale.kotlin.howto

import java.net.URL


fun main() {
    val internetConnectionAvailable = isConnectedToInternetClosure()
    println("Closure :: Is connected to Internet: " + internetConnectionAvailable())
    println("Function :: Is connected to Internet: " + isConnectedToInternetFunc())
}

fun isConnectedToInternetFunc(): Boolean {
    return try {
        val url = URL("https://www.heise.de")
        url.openConnection().connect()
        true
    } catch (e: Exception) {
        false
    }
}

fun isConnectedToInternetClosure(): () -> Boolean {
    return {
        try {
            val url = URL("https://www.heise.de")
            url.openConnection().connect()
            true
        } catch (e: Exception) {
            false
        }
    }
}
