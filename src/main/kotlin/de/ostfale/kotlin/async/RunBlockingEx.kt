package de.ostfale.kotlin.async

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {
    runBlocking {
        println("In block, pos 1")
        launch(Dispatchers.IO) {
            println("C1 started, ${Thread.currentThread()}")
            delay(2000L)
            println("C1 finished")
        }
        launch(Dispatchers.Default) {
            println("C2 started, ${Thread.currentThread()}")
            delay(1000L)
            println("C2 finished")
        }
        println("In block, pos 2")
        delay(500L)
        println("In block , pos 3")
    }
    println("Block finished...")
}
