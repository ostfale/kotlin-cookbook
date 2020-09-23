package de.ostfale.kotlin.classes.nested

import org.slf4j.LoggerFactory

class ObjectExpression {

    private val log = LoggerFactory.getLogger(javaClass)

    fun foo() {
        val startingPoint = object {
            var x: Int = 0
            var y: Int = 0
        }
        log.info("Starting at x= ${startingPoint.x} and y= ${startingPoint.y}")
    }
}

fun main() {
    val myObjectExpression = ObjectExpression()
    myObjectExpression.foo()
}