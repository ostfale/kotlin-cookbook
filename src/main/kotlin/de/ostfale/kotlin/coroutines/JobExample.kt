package de.ostfale.kotlin.coroutines

import kotlinx.coroutines.*
import java.util.*

// the result of running an asynchronous task is called a job
@OptIn(DelicateCoroutinesApi::class)
fun fastUuidAsync() = GlobalScope.async {
    UUID.randomUUID()
}

// needs suspend to run await or runBlocking (which blocks main thread)
//suspend fun main() {
fun main() {
    runBlocking {
        val job: Deferred<UUID> = fastUuidAsync()
        println(job) // DeferredCoroutine{Active}@1c53fd30
        println(job.await()) // 4cd6d501-defa-4fed-9f40-a3e7d516d694
    }
}
