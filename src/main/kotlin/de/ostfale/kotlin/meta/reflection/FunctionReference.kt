package de.ostfale.kotlin.meta.reflection

fun myFunc(a: Int, b: String): Int {
    return a + b.length
}

fun main() {
    val funcRef = ::myFunc
    println("Result: ${funcRef.invoke(1, "Baum")}")
}