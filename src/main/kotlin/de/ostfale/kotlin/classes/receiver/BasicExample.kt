package de.ostfale.kotlin.classes.receiver

// extension function
fun Int.sum(other: Int): Int = this + other

// receiver function: sum saves a method with lambda
val sum: Int.(Int) -> Int = { this + it }
val sum1: Int.(Int) -> Int = { this.plus(it) }
val sum2: Int.(Int) -> Int = { plus(it) } // only for receiver
val sum3: Int.(Int) -> Int = { other -> plus(other) }  // using long lambda

fun main() {
    val aValue = 7
    println("Sum of 7 and 6 is: ${aValue.sum(6)}")
    println("Sum of 7 and 6 is: ${aValue.sum3(6)}")
}