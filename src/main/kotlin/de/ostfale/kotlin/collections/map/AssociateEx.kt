package de.ostfale.kotlin.collections.map

fun main() {
    listToMapEx()
}

@OptIn(ExperimentalStdlibApi::class)
fun listToMapEx() {
    val lst = "abcdefg".toList()
    val map = lst.associateWith { it.code }
    println("Show int value for letter: $map")
}
