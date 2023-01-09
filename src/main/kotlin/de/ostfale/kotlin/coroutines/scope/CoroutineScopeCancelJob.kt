package de.ostfale.kotlin.coroutines.scope

import kotlinx.coroutines.*

suspend fun longTaskCancel() = coroutineScope {
    launch {
        delay(1000)
        val name = coroutineContext[CoroutineName]?.name
        println("[$name] Finished task 1")
    }
    launch {
        delay(2000)
        val name = coroutineContext[CoroutineName]?.name
        println("[$name] Finished task 2")
    }
}

fun main(): Unit = runBlocking {
    val job = launch(CoroutineName("Parent")) {
        longTaskCancel()
    }
    delay(1500)
    job.cancel()
}
