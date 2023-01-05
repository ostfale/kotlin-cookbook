package de.ostfale.kotlin.coroutines.exceptions

import kotlinx.coroutines.*

// SupervisorJob is generally used as part of a scope in which we start multiple coroutines
fun main(): Unit = runBlocking {
    val scope = CoroutineScope(SupervisorJob())
    scope.launch {
        delay(1000)
        throw Error("Some error")
    }
    scope.launch {
        delay(2000)
        println("Will be printed")
    }
    delay(3000)
}
