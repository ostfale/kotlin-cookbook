package de.ostfale.kotlin.coroutines.builder

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeout

fun main() {
    runBlocking {
        try {
            withTimeout(1000L) {
                for (i in (1..10)) {
                    println("Progress: $i")
                    delay(350L)
                }
            }
        } catch (e: Exception) {
            println("Exception: $e")
        }
        println("Continue...")
    }
}
