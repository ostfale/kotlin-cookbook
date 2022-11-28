package de.ostfale.kotlin.coroutines

import kotlinx.coroutines.*

val myHandler = CoroutineExceptionHandler { context, exception ->
    println("Error from handler processed: $exception")
}

fun main() {
    runBlocking {
        GlobalScope.launch(myHandler) { throw Exception("Error in async code") }
    }
    println("Continued after runBlocking")
    Thread.sleep(1000)
}
