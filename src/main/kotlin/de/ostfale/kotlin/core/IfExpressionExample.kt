package de.ostfale.kotlin.core

import org.slf4j.LoggerFactory

/**
 * Examples for use of if-expressions
 *  + last statement returned
 *  + no ternary operator
 */
class IfExpressionExample {

    private val log = LoggerFactory.getLogger(javaClass)

    fun someIfBasics() {
        // don't need ternary operator in Kotlin
        val someCondition = true
        val num = if (someCondition) 50 else 592
        log.info("Result of if-condition: $num")
    }
}

fun main() {
    IfExpressionExample().someIfBasics()
}