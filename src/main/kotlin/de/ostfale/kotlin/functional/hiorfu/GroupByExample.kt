package de.ostfale.kotlin.functional.hiorfu

import org.slf4j.LoggerFactory

class GroupByExample : GroceryList() {

    private val log = LoggerFactory.getLogger(javaClass)

    fun groupedByCategory() {
        val groupByCategory = groceries.groupBy { it.category }
        log.info("Groceries grouped by category: $groupByCategory")
    }

    fun groupByCategoryAndPrintName() {
        groceries.groupBy { it.category }.forEach { entry ->
            log.info(entry.key)
            entry.value.forEach { log.info(" ${it.name}") }
        }
    }
}

fun main() {
    GroupByExample().apply {
        groupedByCategory()
        groupByCategoryAndPrintName()
    }
}