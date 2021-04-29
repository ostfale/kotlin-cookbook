package de.ostfale.kotlin.functional.lambda

fun main() {
    val lst = listOf(1, 2, 3, 4)
    val newList = mutableListOf<Int>()
    for (itm in lst) newList += quadruple(itm)
    println("Traditional way: $newList")
    println("Using a reference: ${lst.map(::quadruple)}")
    println("First lambda: ${lst.map({ itm: Int -> itm * itm })}")
    println("First lambda without type: ${lst.map({ itm -> itm * itm })}")
    println("First lambda with it: ${lst.map({ it * it })}")
    println("First lambda final: ${lst.map { it * it }}")
}

fun quadruple(x: Int): Int = x * x