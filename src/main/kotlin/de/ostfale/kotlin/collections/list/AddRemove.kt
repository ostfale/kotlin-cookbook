package de.ostfale.kotlin.collections.list

fun main() {
    val lst = MutableList(10) { it * it }
    println("Initial list: $lst")
    // remove even numbers
    lst.removeAll { it % 2 == 0 }
    println("List without even numbers: $lst")
    lst.retainAll { it > 5 }
    println("Retains all numbers > 5: $lst")
}