package de.ostfale.kotlin.core

class Point(var x: Int, var y: Int)

fun getPerhapsAPoint(): Point? {
    val n = (-10..10).random()
    if (n < 0) return null
    return Point(n, n)
}

// Safe-Call '?:'
fun nullCheckWithSafeCall() {
    val p = getPerhapsAPoint()
    println("Null check with ?. - safe call: x = ${p?.x} y = ${p?.y}")
}

// combine safe-call with scope function let
fun nullCheckWithSafeCallAndLet() {
    val somePoint = getPerhapsAPoint()
    somePoint?.let {
        println("Null check with safe-call and let: x = ${it.x} y = ${it.y}")
    }
}

// null check with elvis operator
fun nullCheckWithElvisOperator() {
    val somePoint = getPerhapsAPoint()
    println("Null check with Elvis operator: x = ${somePoint?.x ?: -1} y = ${somePoint?.y ?: -1}")
}

fun main() {
    nullCheckWithSafeCall()
    nullCheckWithSafeCallAndLet()
    nullCheckWithElvisOperator()
}