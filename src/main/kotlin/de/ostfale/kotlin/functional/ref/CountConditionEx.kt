package de.ostfale.kotlin.functional.ref

fun main() {
    val lst = listOf(2, 7, 9, 13, 4, 19, 8)
    val even = lst.count { it % 2 == 0 }
    val evenFilter = lst.filter { it % 2 == 0 }.size
    println("Even numbers count: $even")
    println("Even numbers count with filter: $evenFilter")
}