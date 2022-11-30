package de.ostfale.kotlin.coroutines

import kotlinx.coroutines.delay
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit
import kotlin.concurrent.thread
import kotlin.coroutines.Continuation
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

suspend fun resumeInstantly() {
    print("RESUME INSTANTLY :: Before -> ")
    suspendCoroutine<Unit> { continuation -> continuation.resume(Unit) }
    println("After")
}

// Threads are expensive to use
suspend fun resumeAfterThreadDelay() {
    print("RESUME THREAD :: Before -> ")
    suspendCoroutine<Unit> { continuation ->
        thread {
            print("Suspended -> ")
            Thread.sleep(1000)
            continuation.resume(Unit)
            println("Resumed")
        }
    }
    println("After")
}

suspend fun resumingWithExternalThreadDelayFunction() {
    print("RESUME THREAD DELAY FUNCTION :: Before -> ")
    suspendCoroutine<Unit> { continuation -> continueAfterSecond(continuation) }
    println(" After")
}

fun continueAfterSecond(continuation: Continuation<Unit>) {
    thread {
        Thread.sleep(1000)
        continuation.resume(Unit)
    }
}

// JVM Executor Service is cheaper than a thread to be used as Alarm Clock for Coroutine
private val executor = Executors.newSingleThreadScheduledExecutor { Thread(it, "scheduler").apply { isDaemon = true } }

// this is more or less the implementation of the delay function
suspend fun resumeUsingExecutorService() {
    print("RESUME EXECUTOR SERVICE :: Before -> ")
    suspendCoroutine<Unit> { continuation ->
        executor.schedule({ continuation.resume(Unit) }, 1000, TimeUnit.MILLISECONDS)
    }
    println(" After")
}

suspend fun resumeWithDelayFunction() {
    print("RESUME WITH DELAY :: Before -> ")
    delay(1000)
    println(" After")
}

suspend fun main() {
    resumeInstantly()
    resumingWithExternalThreadDelayFunction()
    resumeUsingExecutorService()
    resumeAfterThreadDelay()
    resumeWithDelayFunction()
}
