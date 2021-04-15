package de.ostfale.kotlin.collections.list

fun main() {
    println("Initial list: $lst")
    sumWithReduce()
    mapToNewList()
    randomListElement()
    shuffleElements()
}

fun shuffleElements() {
    val shuffledList = lst.shuffled()
    println("Shuffled list: $shuffledList")
}

fun randomListElement() {
    val rnd = lst.random()
    val rndOrNull = lst.randomOrNull()
    println("Show random val: $rnd or randomOrNull: $rndOrNull")
}

fun mapToNewList() {
    val lstQuad = lst.map { itm -> itm * itm }
    println("New list with quad values: $lstQuad")
}

fun sumWithReduce() {
    val sum = lst.reduce { acc, itm -> acc + itm }
    println("Calculated sum with reduce: $sum")
}

val lst = MutableList(10) { it * it }
