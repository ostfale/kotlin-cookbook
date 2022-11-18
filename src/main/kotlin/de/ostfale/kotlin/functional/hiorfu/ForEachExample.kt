package de.ostfale.kotlin.functional.hiorfu

import org.slf4j.LoggerFactory

class ForEachExample : GroceryList() {
    private val log = LoggerFactory.getLogger(javaClass)

    fun printGroceryNames() {
        groceries.forEach { log.info("Grocery name: ${it.name}") }
        groceries.filter { it.unitPrice > 3.0 }.forEach { println("Grocery name (price > 3): ${it.name}") }
    }
}

fun main() {
    val myForEachExample = ForEachExample()
    myForEachExample.printGroceryNames()
}
