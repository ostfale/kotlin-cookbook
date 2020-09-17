package de.ostfale.kotlin.classes.base

import org.slf4j.LoggerFactory

/**
 * Example for a class without a constructor. Behind the scenes there will be a class with an empty constructor created.
 */
class ClassWithoutConstructor {

    private val log = LoggerFactory.getLogger(javaClass)

    fun quack() {
        log.info("Quack! Quack! Quack!!")
    }
}

fun main() {
    val myDuck = ClassWithoutConstructor()
    myDuck.quack()
}