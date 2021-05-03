package de.ostfale.kotlin.functional.ref

fun main() {
    val lst = List(9) { it }.toMutableList()
    println("Original list $lst")
    lst.remove(4) // removes elemente '4'
    println("Removed 4 from list: $lst")
    val itm = lst.removeAt(5) // remove 6. element
    println("Removed index 5 element $itm and remaining list: $lst")
    lst.removeIf { it % 2 == 0 }
    println("Removed even numbers: $lst")
    lst.removeAll { it % 3 == 0 }
    println("Remove all number modulo 3 : $lst")
}
