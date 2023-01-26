package de.ostfale.kotlin.coroutines

import kotlinx.coroutines.Job
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.slf4j.Logger
import org.slf4j.LoggerFactory

// https://blog.rockthejvm.com/kotlin-coroutines-101/
// add `-Dkotlinx.coroutines.debug` as VM argument


private val log: Logger = LoggerFactory.getLogger("CoroutinePlayground")

suspend fun bathTime() {
    log.info("Going to the bathroom")
    delay(500L)
    log.info("Exiting the bathroom")
}

suspend fun boilingWater() {
    log.info("Boiling water")
    delay(1000L)
    log.info("Water boiled")
}

suspend fun preparingCoffee() {
    log.info("Preparing coffee")
    delay(500L)
    log.info("Coffee prepared")
}

suspend fun sequentialMorningRoutine() {
    coroutineScope {
        bathTime()
    }
    coroutineScope {
        boilingWater()
    }
}

suspend fun concurrentMorningRoutine() {
    // scope here is used for both coroutines (structural concurrency)
    coroutineScope {
        launch {
            bathTime()
        }
        launch {
            boilingWater()
        }
    }
}

suspend fun morningRoutineWithCoffee() {
    coroutineScope {
        val bathTimeJob: Job = launch {
            bathTime()
        }
        val  boilingWaterJob: Job = launch {
            boilingWater()
        }
        bathTimeJob.join()
        boilingWaterJob.join()
        launch {
            preparingCoffee()
        }
    }
}

// same as above function but without job.join - only use nested scope
suspend fun structuralConcurrentMorningRoutineWithCoffee() {
    coroutineScope {
        coroutineScope {
            launch {
                bathTime()
            }
            launch {
                boilingWater()
            }
        }
        launch {
            preparingCoffee()
        }
    }
}

suspend fun main() {
  /*  log.info("Starting the morning routine")
    sequentialMorningRoutine()
    log.info("Ending the morning routine")
    println("------------------------------------------------")*/

/*    log.info("Starting the morning routine")
    concurrentMorningRoutine()
    log.info("Ending the morning routine")
    println("------------------------------------------------")*/

    log.info("Starting the morning routine")
    morningRoutineWithCoffee()
    log.info("Ending the morning routine")
    println("------------------------------------------------")

}

//07:55:23.914 [main] INFO CoroutinePlayground - Starting the morning routine
//07:55:23.929 [main] INFO CoroutinePlayground - Going to the bathroom
                                 //    -> resumes in a different Thread
//07:55:24.459 [kotlinx.coroutines.DefaultExecutor] INFO CoroutinePlayground - Exiting the bathroom
//07:55:24.462 [kotlinx.coroutines.DefaultExecutor] INFO CoroutinePlayground - Boiling water
//07:55:25.469 [kotlinx.coroutines.DefaultExecutor] INFO CoroutinePlayground - Water boiled
//07:55:25.469 [kotlinx.coroutines.DefaultExecutor] INFO CoroutinePlayground - Ending the morning routine

//------------------------------------------------
//08:15:03.194 [main] INFO CoroutinePlayground - Starting the morning routine
                                // -> spawns 2 new coroutines to run each of the functions
//08:15:03.255 [DefaultDispatcher-worker-1 @coroutine#1] INFO CoroutinePlayground - Going to the bathroom
//08:15:03.257 [DefaultDispatcher-worker-2 @coroutine#2] INFO CoroutinePlayground - Boiling water
//08:15:03.773 [DefaultDispatcher-worker-2 @coroutine#1] INFO CoroutinePlayground - Exiting the bathroom
//08:15:04.261 [DefaultDispatcher-worker-2 @coroutine#2] INFO CoroutinePlayground - Water boiledccccccrihgjjdcerufjhltcvgicnrldbglhlrknnlhbr
//08:15:04.261 [DefaultDispatcher-worker-2 @coroutine#2] INFO CoroutinePlayground - Ending the morning routine
//------------------------------------------------


//08:28:39.014 [main] INFO CoroutinePlayground - Starting the morning routine
//08:28:39.072 [DefaultDispatcher-worker-1 @coroutine#1] INFO CoroutinePlayground - Going to the bathroom
//08:28:39.073 [DefaultDispatcher-worker-2 @coroutine#2] INFO CoroutinePlayground - Boiling water
//08:28:39.580 [DefaultDispatcher-worker-1 @coroutine#1] INFO CoroutinePlayground - Exiting the bathroom
//08:28:40.085 [DefaultDispatcher-worker-1 @coroutine#2] INFO CoroutinePlayground - Water boiled
                               // joined the jobs before preparing coffee
//08:28:40.087 [DefaultDispatcher-worker-2 @coroutine#3] INFO CoroutinePlayground - Preparing coffee
//08:28:40.597 [DefaultDispatcher-worker-2 @coroutine#3] INFO CoroutinePlayground - Coffee prepared
//08:28:40.598 [DefaultDispatcher-worker-2 @coroutine#3] INFO CoroutinePlayground - Ending the morning routine
//------------------------------------------------
