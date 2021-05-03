package de.ostfale.kotlin.functional.ref

fun main() {
    val lst = listOf(2, 7, 9, 13, 4, 19, 8)
    val groups = lst.groupBy { if (it % 2 == 0) "even" else "odd" }
    println("Created even/odd groups:  $groups")
}