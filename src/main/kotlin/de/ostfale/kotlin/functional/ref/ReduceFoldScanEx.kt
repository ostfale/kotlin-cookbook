package de.ostfale.kotlin.functional.ref

fun main() {
    reduceEx()
    foldEx()
    scanEx()
}

fun scanEx() {
    val lst = listOf(2, 7, 9, 13, 4, 19, 8)
    val intermediate = lst.scan("") { a, b -> a + b.toString() }
    println("Shows intermediate results: $intermediate")
}

fun foldEx() {
    val lst = listOf(2, 7, 9, 13, 4, 19, 8)
    val concat = lst.fold("") { a, b -> a + b.toString() }
    println("Concat list with fold: $concat")
}

fun reduceEx() {
    val lst = listOf(2, 7, 9, 13, 4, 19, 8)
    val calcSum = lst.reduce { a, b -> a + b }
    val maxVal = lst.reduce { a, b -> if (a > b) a else b }
    println("Calculate sum with reduce: $calcSum")
    println("Calculate max val with reduce: $maxVal")
}
