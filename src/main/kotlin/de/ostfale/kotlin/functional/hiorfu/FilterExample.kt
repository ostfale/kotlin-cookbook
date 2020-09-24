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
}

fun main() {
    FilterExample().apply {
        showVegetables()
        showNotFrozen()
    }
}