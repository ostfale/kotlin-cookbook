package de.ostfale.kotlin.functional.ref

fun main() {
    val lst = List(20) { it }
    val tmp1 = mutableListOf<Int>()
    val tmp2 = mutableListOf<Int>()
    val result = lst.mapTo(tmp1) { it * 2 }.filterTo(tmp2) { it < 10 }.sum()
    println("Result: $result with tmp1: $tmp1 and tmp2: $tmp2")
}