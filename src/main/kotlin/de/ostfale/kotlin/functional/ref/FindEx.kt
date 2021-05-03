package de.ostfale.kotlin.functional.ref

fun main() {
    val lst = List(10) { (0..10).random() }
    val result = lst.find { it > 5 && it % 2 != 0 }
    val answer = if (result is Int) result else "No match"
    println("Result: $answer")
}