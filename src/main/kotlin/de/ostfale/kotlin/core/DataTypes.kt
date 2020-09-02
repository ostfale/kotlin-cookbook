package de.ostfale.kotlin.core

import org.slf4j.LoggerFactory

fun main() {
    val types = Types()
    types.basicType()
    types.toLongConversion()
}

class Types() {

    private val log = LoggerFactory.getLogger(javaClass)

    fun basicType() {
        val myInt = 10
        log.info("Default datatype is Int ${myInt is Int}")

        var myLong: Long = 22
        val myBetterLong = 22L

        val anotherInt = 66
        myLong = anotherInt.toLong() // needs to... function to widen the int

        val otherInt = 5

        // double float examples
        val myDouble = 65.77
        log.info("myDouble is Double: ${myDouble is Double}")

        val myFloat = 848.4433f
        log.info("myFloat is Float: ${myFloat is Float}")

        val anotherDouble: Double
        anotherDouble = myFloat.toDouble()

        // char examples
        val char = 'c'
        val myCharInt = 65
        log.info("Print the char with int = 65: ${myCharInt.toChar()}")
    }

    fun toLongConversion() {
        val x = 5
        val y: Long = x.toLong()
        log.info("Converted an Integer = $x to a Long value of $y using the to... function ")

        val s: Short = 0b10001
        log.info("A shorty for 0b1001: $s")
    }
}