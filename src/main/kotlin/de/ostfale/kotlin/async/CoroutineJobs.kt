package de.ostfale.kotlin.async

import kotlinx.coroutines.*

fun main() {
    joinJobExample()
}

fun joinJobExample() {
    val job = GlobalScope.launch {
        for (i in (1..10)) {
            println("Progress: $i")
            delay((500..2000L).random())
        }
    }
    Thread.sleep(3000L)
    runBlocking { job.join() }
    println("Finished!")
}