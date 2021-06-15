package de.ostfale.kotlin.async

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {
    runBlocking {
        val job = launch(Dispatchers.Default) { doSomething() }
        val s = async(Dispatchers.Default) { buildLongString() }
        job.join()
        println("Long String: ${s.await()}")
    }
}

suspend fun doSomething() {
    var sum = 0L
    for (i in (0..500_000_000L)) {
        sum += i
    }
    println("Long calculation result: $sum")
}

suspend fun buildLongString(): String {
    val sb = StringBuilder()
    for (i in (0..100_000)) {
        sb.append(("0123456789abcdefg".random()))
    }
    return sb.toString().take(100)
}