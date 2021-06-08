package de.ostfale.kotlin.async

import kotlinx.coroutines.*

@OptIn(DelicateCoroutinesApi::class)
fun main() {
    val results = mutableListOf<Deferred<Int>>()
    runBlocking {
        for (i in (1..100)) {
            results += GlobalScope.async {
                val tmp = (0..110).random()
                if (tmp > 100) throw ArithmeticException("Too large...")
                tmp
            }
        }
        // check sum of all elements
        println("Check result ->")
        try {
            val sum = results.awaitAll().sum()
            println(" Sum: $sum")
        } catch (e: Exception) {
            println("Error: $e")
        }
        // check all non error results
        println("Check only valid results ->")
        var sum = 0
        for (result in results) {
            try {
                sum += result.await()
            } catch (e: Exception) {
                println("Error: $e")
            }
        }
        println("Sum of all valid values: $sum")
    }
}