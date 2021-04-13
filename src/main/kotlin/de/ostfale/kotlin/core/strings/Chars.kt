package de.ostfale.kotlin.core.strings

fun main() {
    conversions()
    charMethods()
}

fun charMethods() {
    val c = 'A'

    println("\nIs letter: ${c.isLetter()}")
    println("Is lower case: ${c.isLowerCase()}")
    println("To long : ${c.toLong()}")  // 65
}

fun conversions() {
    val c = 35.toChar()
    val n = 'A'.toInt()

    println("Char: show value of 35: $c")
    println("Numeric value of 'A' : $n")
}