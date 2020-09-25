package de.ostfale.kotlin.functional.hiorfu

import org.slf4j.LoggerFactory

class FilterExample : GroceryList() {

    private val log = LoggerFactory.getLogger(javaClass)

    fun showVegetables() {
        val vegetables = groceries.filter { it.category == "Vegetable" }
        log.info("Vegetables in list: $vegetables")
    }

    fun showNotFrozen() {
        val notFrozen = groceries.filterNot { it.category == "Frozen" }
        log.info("How many products are not frozen: ${notFrozen.size}")
    }

    /**
     * single works the same as filter, and the syntax to implement it is also the same — with the only difference
     * being that single returns only one object that matches the given condition(s). If there is more or nothing an
     * exception is thrown
     */
    fun showSingleVegetable() {
        val result = groceries.single { it.category == "Bakery" }
        log.info("Use single to find one matching object: $result")
    }

    fun showFirstAndLastObject() {
        val firstObject = groceries.first()
        val lastObject = groceries.last()
        log.info("First object in list: $firstObject and the last one is: $lastObject")
    }
}

fun main() {
    FilterExample().apply {
        showVegetables()
        showNotFrozen()
        showSingleVegetable()
        showFirstAndLastObject()
    }
}