package de.ostfale.kotlin.classes.infix

infix fun Int.add(other: Int): Int = this + other

fun main() {
    val sum = 123 add 456
    val sum1 = 333.add(444)
    println("Infix sum: $sum")
    println("Usual sum: $sum1")
}