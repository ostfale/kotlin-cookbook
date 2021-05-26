package de.ostfale.kotlin.classes.extensions

fun String.Companion.spaces(n: Int): String = " ".repeat(n)

fun main() {
    val whitespace = String.spaces(10)
    println("Whitespaces >>>$whitespace<<<")
}