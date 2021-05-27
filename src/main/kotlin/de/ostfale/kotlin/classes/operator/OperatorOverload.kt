package de.ostfale.kotlin.classes.operator

operator fun String.times(n: Int): String {
    return this.repeat(n)
}

fun main() {
    val result = "abc" * 3
    println("Result: $result")
}