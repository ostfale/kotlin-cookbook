package de.ostfale.kotlin.async

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

fun main() {
    val job = GlobalScope.launch {
        for (i in (1..10)) {
            val progress = "*".repeat(i)
            println("Progress: $progress")
            delay((500..2000L).random())
        }
    }
    Thread.sleep(5000)
    job.cancel()
    println("Finished job...")
    Thread.sleep(5000L)
}