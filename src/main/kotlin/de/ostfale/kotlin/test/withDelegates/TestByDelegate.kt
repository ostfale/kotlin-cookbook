package de.ostfale.kotlin.test.withDelegates

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class DefaultCoffee(private val task: Task) : Task by task, Coffee {
    override fun makeCoffee() {
        println("Default Coffee: Drip Drip")
        scope.launch {
            doSomething("making a coffee")
        }
    }

    override fun drinkCoffee() {
        println("Default Coffee: Mhmmmm")
        scope.launch {
            doSomething("drinking coffee")
        }
    }
}

// production task
class DefaultTask : Task {
    override val scope: CoroutineScope
        get() = GlobalScope

    override suspend fun doSomething(taskName: String): Unit {
        scope.launch {
            // Some long network request
            delay(2000L)
            print("I am $taskName")
        }
    }
}

// test task
class TestTask : Task {
    // TODO read article for fixing
    /* override val scope: CoroutineScope
         get() = TestScope()*/

    override suspend fun doSomething(taskName: String): Unit {
        scope.launch {
            print("I am $taskName")
        }
    }
}