package de.ostfale.kotlin.functional.ref

fun main() {
    val set = setOf('A', ' ', '.')
    println("Is there any letter: ${set.any { it.isLetter() }}")
    println("All elements are letter: ${set.all { it.isLetter() }}")
    println("None element is letter: ${set.none { it.isLetter() }}")
    println("123456".all { it.isDigit() })
}