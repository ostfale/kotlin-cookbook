package de.ostfale.kotlin.collections.list

fun main() {
    immutableLists()
    mutableLists()
    buildListExample()
    fillAllElementsWithOtherValue()
}

fun fillAllElementsWithOtherValue() {
    val lst = MutableList(10) { it }
    println("List before fill: $lst")
    lst.fill(0)
    println("List after filled with 0: $lst")
}

@OptIn(ExperimentalStdlibApi::class)
private fun buildListExample() {
    val lst = buildList<Int> {
        add(23)
        for (i in 40..50) {
            add(i)
        }
        removeAt(7)
    }
    println("Experimental: buildList(): $lst")
}

fun mutableLists() {
    val lst = MutableList(10) { 0 }
    val lst1 = MutableList(10) { it * it }
    val lst2 = MutableList(10) { it % 3 == 0 }
    println("MList with 10 elements = 0 : $lst")
    println("MList with 10 elements multiplied: $lst1")
    println("MList with 10 boolean elements %3 : $lst2")
}

fun immutableLists() {
    val lst = List(5) { it }
    println("List with 5 Elements (0-4) $lst")
}