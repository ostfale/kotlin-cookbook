package de.ostfale.kotlin.functional.ref

import kotlin.math.sqrt

fun main() {
    minMaxSumJoinEx()
    sumByLambdaEx()
}

fun sumByLambdaEx() {
    val lst = List(10) { it }
    val sumQuad = lst.sumBy { it * it }
    val sumSqrt = lst.sumOf { sqrt(it.toDouble()) }
    println("Sum of list quads: $sumQuad")
    println("Sum of sqrt of list: $sumSqrt")
}

fun minMaxSumJoinEx() {
    val lst = List(10) { it }
    val sum = lst.sum()
    val max = lst.maxOrNull()
    val concat = lst.joinToString("")

    println("Original list: $lst with sum: $sum and max: $max")
    println("List as string: $concat")
}
