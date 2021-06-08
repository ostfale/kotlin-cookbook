package de.ostfale.kotlin.async

import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@OptIn(DelicateCoroutinesApi::class)
fun main() {
    showScopeInfo()
    GlobalScope.launch {
        delay(1000L)
        println("These are the Coroutines with no Threads: ${Thread.activeCount()}")
    }
    println("Simply a hello...")
    Thread.sleep(2000L)
}

@OptIn(DelicateCoroutinesApi::class)
fun showScopeInfo() {
    GlobalScope.launch {
        println("Number of Threads: ${Thread.activeCount()}")
        println("Thread Name: ${Thread.currentThread().name}")
    }
}