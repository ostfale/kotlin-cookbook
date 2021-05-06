package de.ostfale.kotlin.functional.scopefunctions

fun main() {
    simpleAlsoEx()
}

fun simpleAlsoEx() {
    val groups = words
        .groupBy { it.length }
        .mapValues { it.value.distinct().count() }
        .also {
            println("Debugging start")
            it.forEach(::println)
            println("Debugging end")
        }.toSortedMap()
    println("Result: $groups")
}

const val txt = "Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor"
val words = txt.split(" ")