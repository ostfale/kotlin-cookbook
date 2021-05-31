package de.ostfale.kotlin.generics.basic

fun <T : Comparable<T>> min(a: T, b: T): T {
    return if (a < b) a else b
}

fun <T : Comparable<T>> min(a: T, b: T, c: T): T = min(a, min(b, c))

fun main() {
    println("Result: ${min(23, 44, 33)}")
}