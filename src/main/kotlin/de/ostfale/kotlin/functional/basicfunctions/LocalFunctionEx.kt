package de.ostfale.kotlin.functional.basicfunctions

fun main() {
    println("Nested (local) function result: ${f1()}")
}

fun f1(): Int {
    val abc = 12
    var result = 3

    fun f2(): Int = abc + 12

    result += f2()
    return result
}