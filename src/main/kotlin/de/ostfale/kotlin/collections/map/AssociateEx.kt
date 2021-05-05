package de.ostfale.kotlin.collections.map

fun main() {
    listToMapEx()
}

fun listToMapEx() {
    val lst = "abcdefg".toList()
    val map = lst.associateWith { it.toInt() }
    println("Show int value for letter: $map")
}
