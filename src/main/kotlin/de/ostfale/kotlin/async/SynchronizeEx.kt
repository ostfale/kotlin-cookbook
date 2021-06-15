package de.ostfale.kotlin.async

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import java.util.concurrent.atomic.AtomicInteger

fun main() {
    threadsafeCounter()
    mutexEx()
}

fun mutexEx() {
    val myMutex = Mutex()
    var sharedCounter = 0
    runBlocking {
        for (i in (1..250_000)) {
            launch(Dispatchers.Default) {
                delay((0..100L).random())
                myMutex.withLock { sharedCounter += 1 }
            }
        }
    }
    println("Using mutex for access shared var: $sharedCounter")
}

fun threadsafeCounter() {
    var sharedCounterUnsafe = 0  // not threadsafe
    var sharedCounterSafe = AtomicInteger(0)
    runBlocking {
        for (i in (1..250_000)) {
            launch(Dispatchers.Default) {
                delay((0..100L).random())
                sharedCounterUnsafe += 1
                sharedCounterSafe.incrementAndGet()
            }
        }
    }
    println("Not Threadsafe should be 250 000: $sharedCounterUnsafe") // 248672
    println("Threadsafe should be 250 000: $sharedCounterSafe") // 250000
}