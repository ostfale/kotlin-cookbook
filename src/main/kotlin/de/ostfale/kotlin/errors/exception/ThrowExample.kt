package de.ostfale.kotlin.errors.exception

fun divide(a: Int, b: Int): Int {
    if (b == 0)
        throw IllegalArgumentException("b must not 0")
    return a / b
}