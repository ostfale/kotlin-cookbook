package de.ostfale.kotlin.howto

import org.slf4j.LoggerFactory
import java.net.URL

class CheckInternetConnection {
    private val log = LoggerFactory.getLogger(javaClass)

    fun checkConnection(): Boolean {
        return try {
            val url = URL("https://www.heise.de")
            url.openConnection().connect()
            log.info("Connected to internet")
            true
        } catch (e: Exception) {
            log.info("No connection to internet")
            false
        }
    }
}

fun main() {
    CheckInternetConnection().checkConnection()
}
