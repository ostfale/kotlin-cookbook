package de.ostfale.kotlin.coroutines.scope

import kotlinx.coroutines.*

// In the example below, you can observe that “After” will be printed at the end because coroutineScope will not finish
// until all its children are finished. Also, CoroutineName is properly passed from parent to child.
suspend fun longTask() = coroutineScope {
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

fun main() = runBlocking(CoroutineName("Parent")) {
    println("Before")
    longTask()
    println("After")
}
