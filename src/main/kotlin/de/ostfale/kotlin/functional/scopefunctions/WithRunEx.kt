package de.ostfale.kotlin.functional.scopefunctions

fun main() {
    println("Example with run: $numberOfCharacters")
}

val message = StringBuilder()
val numberOfCharacters = message.run {
    append("This is a transformation function.")
    append("It takes a StringBuilder instance and returns the number of characters in the generated String")
    length
}