package de.ostfale.kotlin.functional.extensions.helper

val Int.binary get() = toString(2)
val Int.octal get() = toString(8)
val Int.hexadecimal get() = toString(16)

fun main() {
    println(120.binary)
    println(120.octal)
    println(120.hexadecimal)
}