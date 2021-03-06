package de.ostfale.kotlin.core.strings

fun main() {
    conversions()
    charMethods()
}

@OptIn(ExperimentalStdlibApi::class)
fun charMethods() {
    val c = 'A'

    println("\nIs letter: ${c.isLetter()}")
    println("Is lower case: ${c.isLowerCase()}")
    println("To long : ${c.code}")  // 65
}

@OptIn(ExperimentalStdlibApi::class)
fun conversions() {
    val c = 35.toChar()
    val n = 'A'.code

    println("Char: show value of 35: $c")
    println("Numeric value of 'A' : $n")
}