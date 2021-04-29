package de.ostfale.kotlin.functional.lambda

import kotlin.math.sqrt

fun main() {
    createQuadraticFunction()
    printTable(makeFunc(), 5.0, 7.0)
    printTable(::sqrt, 0.1, 2.0, 20)
}

// f(x) = ax²+bx + c
fun createQuadraticFunction() {
    println("Result of f(x) = ax² + bx + c for x = 3 : ${makeFunc(1.0, 2.0, 3.0).invoke(3.0)}")
    println("Result of f(x) = ax² + bx + c for x = 3 : ${makeFunc(2.0, 3.0, 4.0).invoke(3.0)}")
}

private fun makeFunc(a: Double = 2.0, b: Double = 3.0, c: Double = 4.0): (Double) -> Double {
    return { x -> a * x * x + b * x + c }
}

private fun printTable(f: (Double) -> Double, from: Double, to: Double, number: Int = 11) {
    println()
    println("           x |          f(x)")
    println("------------ + -------------")
    for (i in 0 until number) {
        val x = from + (to - from) / (number - 1) * i
        val output = "%10.5f  |  %10.5f"
        println(output.format(x, f(x)))
    }

}