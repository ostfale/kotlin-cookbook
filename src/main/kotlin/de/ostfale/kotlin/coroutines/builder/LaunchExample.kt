package de.ostfale.kotlin.coroutines.builder

import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@OptIn(DelicateCoroutinesApi::class)
fun main() {
    GlobalScope.launch {
        delay(1000L)
        println("World!")
    }
    print("Hello ")
    Thread.sleep(2000L)
}
