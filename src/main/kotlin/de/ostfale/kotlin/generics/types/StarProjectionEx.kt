package de.ostfale.kotlin.generics.types

fun Iterable<*>.countNotNull(): Int {
    var cnt = 0
    for (itm in this) {
        if (itm != null)
            cnt++
    }
    return cnt
}

fun main() {
    val lst = listOf(1, "abc", null)
    println("Number of non null elements: ${lst.countNotNull()}")
}