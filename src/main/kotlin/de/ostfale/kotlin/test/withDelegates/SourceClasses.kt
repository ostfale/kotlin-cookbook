package de.ostfale.kotlin.test.withDelegates

import kotlinx.coroutines.*

// https://dev.to/touchlab/easier-testing-with-kotlin-delegates-3o0k

interface Task {
    @OptIn(DelicateCoroutinesApi::class)
    val scope: CoroutineScope
        get() = GlobalScope

    suspend fun doSomething(taskName: String): Unit {
        scope.launch {
            delay(1000L)
            println("I am $taskName")
        }
    }
}

interface Coffee : Task {
    fun makeCoffee() {
        println("Drip Drip")
        scope.launch {
            doSomething("making coffee")
        }
    }

    fun drinkCoffee() {
        println("Mmmmm...")
        scope.launch {
            doSomething("drinking coffee")
        }
    }
}

interface Breakfast : Task {
    fun eatBreakfast() {
        println("Om nom nom")
        scope.launch {
            doSomething("eating breakfast")
        }
    }
}

interface Morning : Task, Coffee, Breakfast

class DefaultMorning : Morning {
    fun morningRoutine() {
        makeCoffee()
        drinkCoffee()
        eatBreakfast()
    }

    override suspend fun doSomething(taskName: String) {
        scope.launch {
            delay(15000L)
            println("I'm tired and I'm $taskName")
        }
    }
}

fun main() {
    DefaultMorning().morningRoutine()
}