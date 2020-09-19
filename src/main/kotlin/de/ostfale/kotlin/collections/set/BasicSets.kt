package de.ostfale.kotlin.collections.set

import org.slf4j.LoggerFactory

class BasicSets {

    private val log = LoggerFactory.getLogger(javaClass)

    private val friendSet = setOf("Jim", "Sue", "Nick")
    private val friendSetDuplicate = setOf("Jim", "Sue", "Sue", "Nick")

    fun ignoreDuplicateValues() {
        log.info("Set with duplicate value: $friendSetDuplicate")
    }

    fun checkForExistingValue() {
        log.info("Does set contain the name 'Fred': ${friendSet.contains("Fred")}")
    }

    fun printAllSetItems() {
        for (item in friendSet) {
            log.info("Item in set: $item")
        }
    }
}

fun main() {
    val myBasicSets = BasicSets()
    myBasicSets.ignoreDuplicateValues()
    myBasicSets.checkForExistingValue()
    myBasicSets.printAllSetItems()
}