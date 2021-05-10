package de.ostfale.kotlin.core.loops

import org.slf4j.LoggerFactory
import java.math.BigDecimal

fun main() {

    WhenExpression().apply {
        basicUse()
        useRanges()
        useExpressions()
        useTypes()
        assignTypeToVariable()
        usingEnums()
        comparingValues()
    }

}

/**
 * <ul>
 *     <li>https://medium.com/androiddevelopers/kotlin-demystified-the-power-of-when-f0ac616ddd1a</li>
 * </ul>
 */
class WhenExpression {

    private val log = LoggerFactory.getLogger(javaClass)

    fun basicUse() {
        when (100) {
            100, 600 -> log.info("600")
            200 -> log.info("200")
            else -> log.info("Doesn't match anything....")
        }
    }

    fun useRanges() {
        when (100) {
            in 100..199 -> log.info("in range 100..199")
            200 -> log.info("200")
            else -> log.info("Doesn't match anything....")
        }
    }

    fun useExpressions() {
        val num = 100
        val y = 10

        when (num) {
            y + 80 -> log.info("90")
            y + 90 -> log.info("100")
            else -> log.info("Doesn't match anything....")
        }
    }

    fun useTypes() {
        val obj: Any = "I am a string"
        val obj1: Any = BigDecimal(25.2)
        val obj2: Any = 45

        when (val something: Any = obj) {
            is String -> log.info(something.uppercase())
            is BigDecimal -> log.info("Found: {}", something.remainder(BigDecimal(10.5)))
            is Int -> log.info("${something - 22}")
        }
    }

    fun assignTypeToVariable() {
        val obj: Any = "I am a string"
        val obj1: Any = BigDecimal(25.2)
        val obj2: Any = 45

        val z = when (val something: Any = obj) {
            is String -> {
                log.info(something.uppercase())
            }
            is BigDecimal -> log.info("Found: {}", something.remainder(BigDecimal(10.5)))
            is Int -> log.info("${something - 22}")
            else -> log.info("No Idea, what type it is")
        }
        log.info("Finally: {}", z)
    }

    fun usingEnums() {
        val timeOfTheYear = Season.SPRING
        var num = 100

        val str = when (timeOfTheYear) {
            Season.SPRING -> {
                num += 5
                "Flowers ar blooming"
            }
            Season.SUMMER -> "It's hot"
            Season.AUTUMN -> "It's getting cooler"
            Season.WINTER -> "Don't like it...."
        }
        log.info("String returned: $str and num value: $num")
    }

    fun comparingValues() {
        val firstNum = 100
        val secondNum = 200

        when {
            firstNum < secondNum -> log.info("First num is smaller than second num")
            firstNum > secondNum -> log.info("First num is greater than second num")
            else -> log.info("First num = Second num")
        }
    }
}

enum class Season {
    SPRING, SUMMER, AUTUMN, WINTER;
}











