package de.ostfale.kotlin.coroutines.builder

import kotlinx.coroutines.*

class CancelExample {
    // check for cancel happens between state changes (caused by yield())
    val cancellable = GlobalScope.launch {
        try {
            for (i in 1..1000) {
                println("Cancellable: $i")
                yield()
            }
        } catch (e: CancellationException) {
            e.printStackTrace()
        }
    }

    // no state changes = no cancelling
    val notCancellable = GlobalScope.launch {
        for (i in 1..10_000) {
            if (i % 1000 == 0) {
                println("Not cancellable $i")
            }
        }
    }
}


fun main() {
    runBlocking {
        val cancelExample = CancelExample()
        println("Canceling cancellable")
        cancelExample.cancellable.cancel()
        println("Canceling not cancellable")
        cancelExample.notCancellable.cancel()

        cancelExample.cancellable.join()
        cancelExample.notCancellable.join()
    }
}
