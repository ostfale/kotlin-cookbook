package de.ostfale.kotlin.collections.list

import java.text.Collator
import java.util.*

fun main() {
    simpleSort()
    sortedByExample()
    sortWithExample()
}

// search with locale
fun sortWithExample() {
    val txt = "Bar Arbeit Barenboim Bär Aal Ärger"
    val lst = txt.split(" ").toMutableList()
    val german = Collator.getInstance(Locale("de"))
    lst.sortWith(german)
    println("Sort with german locale: $lst")
}

fun sortedByExample() {
    val lst = s.split(" ").toMutableList()
    lst.sortBy { it.toLowerCase() }
    println("Show sortedBy with all lowercase: $lst")
    lst.sortBy { it.length }
    println("SortedBy word length: $lst")
}

fun simpleSort() {
    val lst = s.split(" ").toMutableList()
    lst.sort()
    println("Show sort: $lst")
}

const val s = "Lorem ipsum dolor sit amet consetetur sadipscing elitr"