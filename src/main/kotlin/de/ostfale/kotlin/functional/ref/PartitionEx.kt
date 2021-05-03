package de.ostfale.kotlin.functional.ref

fun main() {
    partitionEx()
}

fun partitionEx() {
    val lst = listOf(-3, -2, -1, 0, 1, 2, 3)
    val (odd, even) = lst.partition { it % 2 == 0 }
    println("Even numbers: $even and odd numbers: $odd")
}
