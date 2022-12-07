package de.ostfale.kotlin.coroutines.builder

import kotlinx.coroutines.*
import java.util.*

@OptIn(DelicateCoroutinesApi::class)
fun fastUUIDAsync() = GlobalScope.async {
    UUID.randomUUID()
}

fun main() {
    runBlocking {
        val job: Job = fastUUIDAsync()
        val result: Deferred<UUID> = fastUUIDAsync()
        println(job)  // DeferredCoroutine{Active}@4c75cab9 => Job is only Interface
        println(result.await()) // Deferred extends Job to get await function
    }
    introAsync()
}

@OptIn(DelicateCoroutinesApi::class)
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

