package de.ostfale.kotlin.functional.basicfunctions

fun main() {
    println("Factorial of 15: ${factorial(15)}")
}

// n > 20 => overflow
fun factorial(n: Long): Long {
    return if (n <= 1) 1
    else n * factorial(n - 1)
}