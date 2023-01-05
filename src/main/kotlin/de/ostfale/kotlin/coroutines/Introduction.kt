package de.ostfale.kotlin.coroutines

import kotlinx.coroutines.*
import java.util.concurrent.Executors

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

fun runningWithThreadPoolCoresSize() {
    Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors()).asCoroutineDispatcher().use { context ->
        println("Start thread pool with ${Runtime.getRuntime().availableProcessors()} threads")
        runBlocking {
            launch(context) { task1() }
            launch { task2() }
            println("Called task1 and task2 from ${Thread.currentThread()}")
        }
    }
    println("Done")
}

fun customThreadPool() {
    // use function closes thread from Executor after the coroutines have finished
    Executors.newSingleThreadExecutor().asCoroutineDispatcher().use { context ->
        println("Start custom thread")
        runBlocking {
            launch(context) { task1() }
            launch { task2() }
            println("Called task1 and task2 from ${Thread.currentThread()}")
        }
    }
    println("Done")
}

fun parallelTasks() {
    println("Start parallel task")
    runBlocking {
        launch(Dispatchers.Default) { task1() }
        launch { task2() }
        println("Called task1 and task2 from ${Thread.currentThread()}")
    }
    println("done")
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
    println("----------------------------------")
    parallelTasks()
    println("----------------------------------")
    customThreadPool()
    println("----------------------------------")
    runningWithThreadPoolCoresSize()
}
