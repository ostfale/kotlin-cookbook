package de.ostfale.kotlin.coroutines.builder

import kotlinx.coroutines.*
import java.util.*


fun main() {
    val job : Job = fastUUIDAsync()
    println(job)
}

@OptIn(DelicateCoroutinesApi::class)
fun fastUUIDAsync() = GlobalScope.async {
    UUID.randomUUID()
}

@OptIn(DelicateCoroutinesApi::class)
fun printAsync() {
    runBlocking {
        val resultDeferred: Deferred<Int> = GlobalScope.async {
            delay(1000L)
            42
        }
        // do other stuff...
        println(resultDeferred.await()) // 42
    }
}
