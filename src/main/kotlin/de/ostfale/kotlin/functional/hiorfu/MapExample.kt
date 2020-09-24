package de.ostfale.kotlin.functional.hiorfu

import org.slf4j.LoggerFactory

class MapExample : GroceryList() {

    private val log = LoggerFactory.getLogger(javaClass)

    fun mapNameList(): List<String> {
        val groceryNames = groceries.map { it.name }
        log.info("All grocery names: $groceryNames")
        return groceryNames
    }

    fun chainingFilterAndMap(): List<Double> {
        val newPrices = groceries.filter { it.unitPrice > 3 }.map { it.unitPrice * 2 }
        log.info("Double price of all groceries with unitprice > 3 : $newPrices")
        return newPrices
    }
}

fun main() {
    MapExample().apply {
        mapNameList()
        chainingFilterAndMap()
    }
}