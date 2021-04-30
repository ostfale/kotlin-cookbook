package de.ostfale.kotlin.functional.ref

fun main() {
    filterEx()
    filterNotNullEx()
    filterIsInstanceEx()
}

fun filterIsInstanceEx() {
    val lst = listOf(1, "abc", 2.0, "efg")
    val strings = lst.filterIsInstance<String>()

    println("Original List: $lst")
    println("String filter: $strings")
}

fun filterNotNullEx() {
    val lstWithNull = listOf(1, 2, 3, 4, null)
    val lstWithoutNull = lstWithNull.filterNotNull()

    println("Original List: $lstWithNull")
    println("List without null: $lstWithoutNull")
}

fun filterEx() {
    val lorem = "Lorem ipsum dolor sit amet, consetetur sadipscing"
    val lst = lorem.split(" ")
    val longWords = lst.filter { it.length > 6 }

    println("Show words > 6 char: $longWords")
}
