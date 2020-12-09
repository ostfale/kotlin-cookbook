package de.ostfale.kotlin.functional.sam

// https://kotlin.christmas/2020/2

fun interface Predicate<T> {
    fun accept(value: T): Boolean
}

typealias StringPredicate = Predicate<String>

fun main() {
    val hello = Predicate<String> { it.startsWith("Hello") }
    val world = StringPredicate { it.endsWith("World") }

    println(hello.accept("Hello, World"))
    println(world.accept("Hello, World"))
    println("What is the type of hello:  $hello")
}