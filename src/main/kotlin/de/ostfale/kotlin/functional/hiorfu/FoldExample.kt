package de.ostfale.kotlin.functional.hiorfu

import org.slf4j.LoggerFactory

class FoldExample : GroceryList() {

    private val log = LoggerFactory.getLogger(javaClass)

    private val intList = listOf(1, 2, 3, 4)

    fun addValtoList() {
        val sumOfInts = intList.fold(0) { runningSum, item -> runningSum + item }
        log.info("Sum of Ints: $sumOfInts")
    }

    fun multiplyAllVals() {
        val productOfInts = intList.fold(1) { runningSum, item -> runningSum * item }
        log.info("Product of Ints: $productOfInts")
    }

    fun concateGroceryNames() {
        val conName = groceries.fold("") { string, item -> string + item.name }
        log.info("Grocery Names concatenated: $conName")
    }

    fun subtractPriceGroceries() {
        val result = groceries.fold(50.0) { change, item -> change - item.unitPrice * item.quantity }
        log.info("Show result: $result")
    }
}

fun main() {
    FoldExample().apply {
        addValtoList()
        multiplyAllVals()
        concateGroceryNames()
        subtractPriceGroceries()
    }
}