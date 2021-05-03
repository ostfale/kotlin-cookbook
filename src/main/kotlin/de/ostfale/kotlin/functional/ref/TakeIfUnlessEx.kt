package de.ostfale.kotlin.functional.ref

fun main() {
    takeIfEx()
    takeUnlessEx()
}

fun takeUnlessEx() {
    val s = readLine()!!  // enter via keyboard
    val input = s.takeUnless { it.length > 10 }
    println("Input max length 10 : $input")
}

fun takeIfEx() {
    val x = (0..10).random()
    val y = x.takeIf { it % 2 == 0 }  // is Int
    println("Check if number $x is even: $y")
}
