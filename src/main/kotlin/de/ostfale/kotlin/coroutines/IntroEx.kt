package de.ostfale.kotlin.coroutines

import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.concurrent.CountDownLatch
import java.util.concurrent.TimeUnit
import java.util.concurrent.atomic.AtomicInteger

@OptIn(DelicateCoroutinesApi::class)
fun main() {
    showScopeInfo()
    GlobalScope.launch {
        delay(1000L)
        println("These are the Coroutines with no Threads: ${Thread.activeCount()}")
    }
    println("Simply a hello...")
    Thread.sleep(2000L)
    runWithCountDownLatch()
}

@OptIn(DelicateCoroutinesApi::class)
fun showScopeInfo() {
    GlobalScope.launch {
        println("Number of Threads: ${Thread.activeCount()}")
        println("Thread Name: ${Thread.currentThread().name}")
    }
}

@OptIn(DelicateCoroutinesApi::class) // GlobalScope shouldn't be used in real world projects
fun runWithCountDownLatch() {
    val latch = CountDownLatch(10_000)
    val c = AtomicInteger()
    val start = System.currentTimeMillis()

    for (i in 1..10_000) {
        GlobalScope.launch {
            c.incrementAndGet()
            delay(100)
            c.incrementAndGet()
            latch.countDown()
        }
    }
    latch.await(10, TimeUnit.SECONDS)
    println("Executed ${c.get() / 2} coroutines in ${System.currentTimeMillis() - start} ms")
}
