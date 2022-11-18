package de.ostfale.kotlin.functional.lambda

import org.slf4j.LoggerFactory
import kotlin.math.sqrt

/**
 * Examples for Lambda expressions
 * Declaration: <br>
 *   <ul>
 *     <li> <code>val name : Type = { parameters -> body } </code></li>
 *     <li> <code>val name : Type = { (param1, param2 ) -> body } </code></li>
 *    </ul>
 * Created :  24.08.2020
 *
 *  @author : Uwe Sauerbrei
 */
fun main() {
    val lambdaExamples = LambdaExamples()
    lambdaExamples.lambdaWithOneArg()
    lambdaExamples.lambdaWithTwoArgs()
    lambdaExamples.printAllDwarfs()
}

class LambdaExamples {
    private val log = LoggerFactory.getLogger(javaClass)

    fun lambdaWithOneArg() {
        val squareRootFull: (Int) -> Double = { number: Int -> sqrt(number.toDouble()) }
        val squareRoot = { number: Int -> sqrt(number.toDouble()) }

        log.info("Simple lambda  with full syntax and one arg: {}", squareRootFull(625))
        log.info("Simple lambda with simple syntax and one arg: {}", squareRoot(625))
    }

    fun lambdaWithTwoArgs() {
        val multiplication = { a: Int, b: Int -> a * b }
        val multiplicationRetDouble = { a: Int, b: Int ->
            val res = a * b
            res.toDouble()
        }

        log.info("Lambda with two args returning an int: {}", multiplication(6, 7))
        log.info("Lambda with two args returning a double: {}", multiplicationRetDouble(6, 7))
    }

    fun printAllDwarfs() {
        val dwarfList = listOf("Dwalin", "Balin", "Thorin")
        for (d in dwarfList) {
            log.info("Dwarf: $d")
        }
        dwarfList.forEach { it -> log.info("It-Lambda-Dwarf: $it") }
        dwarfList.forEach { log.info("Lambda-Dwarf: $it") }
        dwarfList.forEach(::println)
    }
}

