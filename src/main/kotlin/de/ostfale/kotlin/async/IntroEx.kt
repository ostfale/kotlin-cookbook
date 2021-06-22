package de.ostfale.kotlin.async

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

fun main() {
    showScopeInfo()
    GlobalScope.launch {
        delay(1000L)
        println("These are the Coroutines with no Threads: ${Thread.activeCount()}")
    }
    println("Simply a hello...")
    Thread.sleep(2000L)
}

fun showScopeInfo() {
    GlobalScope.launch {
        println("Number of Threads: ${Thread.activeCount()}")
        println("Thread Name: ${Thread.currentThread().name}")
    }
}