package de.ostfale.kotlin.core.loops

class Point(var x: Double, var y: Double)

fun main() {
    someIfBasics()
    smartCast()
}

fun smartCast() {
    val p: Point? = null
    if (p is Point) println("Not Null") else println("Is Null")
}

fun someIfBasics() {
    // don't need ternary operator in Kotlin
    val someCondition = true
    val num = if (someCondition) 50 else 592
    println("Condition met: $num")
}