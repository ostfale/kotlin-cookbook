package de.ostfale.kotlin.functional.ref

fun main() {
    basicEx()
    flatMapEx()
    mapNotNullEx()
}

fun mapNotNullEx() {
    val lst = listOf(1, -2, 7, 12, -5)
    val res = lst.mapNotNull { if (it > 0) it + 3 else null }
    println("No nulls inside: $res")
}

fun flatMapEx() {
    val lst = listOf(1, 2, 3)
    val nested = lst.map { (1..it).toList() }
    val flat = lst.flatMap { (1..it).toList() }

    println("Nested list: $nested")
    println("Flat list: $flat")
}

fun basicEx() {
    val lst = "lorem ipsum".toList()  // List<Char>
    val upper = lst.map { it.uppercase() }
    val ascii = lst.map { it.code }

    println("Original list: $lst")
    println("Upper Case list: $upper")
    println("Ascii list: $ascii")
}
