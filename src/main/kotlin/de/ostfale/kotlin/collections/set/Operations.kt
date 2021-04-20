package de.ostfale.kotlin.collections.set

fun main() {
    unionEx()
    intersectEx()
    subtractEx()
}

fun subtractEx() {
    val s1 = "abcde".toSet()
    val s2 = "aeiou".toSet()
    val subtract = s1 subtract s2
    println("Subtract example: $subtract")
    println("Subtract example sorted: ${subtract.toList().sorted()}")
}

fun intersectEx() {
    val s1 = "abcde".toSet()
    val s2 = "aeiou".toSet()
    val intersect = s1.intersect(s2)
    println("Intersection result: $intersect")
    println("Intersection result sorted: ${intersect.toList().sorted()}")
}

private fun unionEx() {
    val s1 = "abcde".toSet()
    val s2 = "aeiou".toSet()
    var union = s1.union(s2)
    println("Show union: $union")
    println("Show union sorted: ${union.sorted()}")
}

