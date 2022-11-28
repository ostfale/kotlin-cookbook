package de.ostfale.kotlin.coroutines

import kotlinx.coroutines.*

fun main() {
    introAsync()
}

fun introAsync() {
    val longText = "lorem ipsum"
    val result = GlobalScope.async(Dispatchers.IO) {
        longText.toSet().count()
    }
    println("After async...")
    runBlocking {
        println("Result is: ${result.await()}")
    }
}
