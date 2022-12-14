package de.ostfale.kotlin.coroutines

import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.yield

fun task1() {
    println("start task1 in Thread ${Thread.currentThread()}")
    println("end task1 in Thread ${Thread.currentThread()}")
}

fun task2() {
    println("start task2 in Thread ${Thread.currentThread()}")
    println("end task2 in Thread ${Thread.currentThread()}")
}

suspend fun task11() {
    println("start task1 in Thread ${Thread.currentThread()}")
    yield()
    println("end task1 in Thread ${Thread.currentThread()}")
}

suspend fun task22() {
    println("start task2 in Thread ${Thread.currentThread()}")
    yield()
    println("end task2 in Thread ${Thread.currentThread()}")
}

fun suspendTasks() {
    println("Start launching")
    runBlocking {
        launch { task11() }
        launch { task22() }
        println("Called task11 and task22 from ${Thread.currentThread()}")
    }
    println("done")
}

fun launchingTask() {
    println("Start Launching")
    runBlocking {
        launch { task1() }
        launch { task2() }
        println("Called task1 and task2 from ${Thread.currentThread()}")
    }
    println("Done")
}

fun concurrentExecutionWithinThread() {
    println("Start Concurrent")
    runBlocking { task1(); task2(); println("Called task1 and task2 from ${Thread.currentThread()}") }
    println("Done")
}

fun sequentialExecution() {
    println("Start Sequential")
    run { task1(); task2(); println("Called task1 and task2 from ${Thread.currentThread()}") }
    println("Done")
}

fun main() {
    sequentialExecution()
    println("----------------------------------")
    concurrentExecutionWithinThread()
    println("----------------------------------")
    launchingTask()
    println("----------------------------------")
    suspendTasks()
}
