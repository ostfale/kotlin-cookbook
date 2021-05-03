package de.ostfale.kotlin.functional.ref

fun main() {
    val letters = "Hello World".toList().filter { it.isLetter() }.sorted()
    println("First letter: ${letters.first()}")
    println("Last letter: ${letters.last()}")
}