package de.ostfale.kotlin.collections.arrays

import org.slf4j.LoggerFactory
import java.math.BigDecimal


fun main() {
    val examples = ArrayExamples()
    examples.initArray()
    examples.initPrimitiveArray()
    examples.initWithLambda()
    examples.createNullArray()
    examples.reverseArray()
    examples.arrayCalculations()
}

class ArrayExamples {

    private val log = LoggerFactory.getLogger(javaClass)

    fun initArray() {
        val myArray = arrayOf(1, 2, 3)
        log.info("Print array: ${myArray.contentToString()}")
        log.info("First element: ${myArray[0]}")
        log.info("Array size: ${myArray.size}")

        val longs = arrayOf(1L, 2L, 3L)
        val longs1 = arrayOf<Long>(1, 2, 3)

        log.info("longs is an array of Long: ${longs is Array<Long>}")
        log.info("longs1 is an array of Long: ${longs1 is Array<Long>}")
        log.info("myArray is an array of Int: ${myArray is Array<Int>}")

        // array of Any
        val mixedArray = arrayOf("hello", 66, BigDecimal(33.4), 'c')
        for (elem in mixedArray) {
            log.info("Any array elemente: $elem")
        }
    }

    fun initPrimitiveArray() {
        val somePrimitiveArray = IntArray(5)
        for (value in somePrimitiveArray) {
            log.info("Initialized primitive Value: $value")
        }
    }

    fun initWithLambda() {
        val evenNumbers = Array(5) { i -> i * 2 }
        log.info(" +++++++++++++++++++ Init Array with Lambda +++++++++++++++++++++++++++")
        for (num in evenNumbers) {
            log.info("Array initialized with lambda: $num")
        }

        val lotsOfNumbers = Array(100_000) { i -> i }
        log.info("No of elements in lotsOfNumbers: ${lotsOfNumbers.size}")
        val allZeros = Array(100) { 0 }
    }

    // creates an array of size 2 initialized with null values
    fun createNullArray() {
        val nullArray: Array<String?> = arrayOfNulls(2)
        log.info(" +++++++++++++++++++ Null Array +++++++++++++++++++++++++++")
        log.info("Print null array: ${nullArray.contentToString()}")

        val nullableInts = arrayOfNulls<Int>(5)
        for (i in nullableInts) {
            log.info("$i") // 5 x null
        }
    }

    fun reverseArray() {
        val myArray = arrayOf(1, 2, 3, 4)
        myArray.reverse()
        log.info(" +++++++++++++++++++ Reverse Array +++++++++++++++++++++++++++")
        log.info("Print reversed array: ${myArray.contentToString()}")
    }

    fun arrayCalculations() {
        val myArray = arrayOf(1, 2, 3, 4)
        log.info(" +++++++++++++++++++ Array Calculations +++++++++++++++++++++++++++")
        log.info("Calculated min of items: ${myArray.minOrNull()}")
        log.info("Calculated max of items: ${myArray.maxOrNull()}")
        log.info("Calculated average of items: ${myArray.average()}")
        log.info("Calculated sum of items: ${myArray.sum()}")

        val isThere = myArray.contains(2)
        log.info("Is value 2 contained in array: $isThere")
    }
}