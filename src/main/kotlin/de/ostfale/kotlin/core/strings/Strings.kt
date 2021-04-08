package de.ostfale.kotlin.core

// https://kotlin.christmas/2020/6

fun main() {
    formattingExamples()
}

fun formattingExamples() {
    val dollars = 100.00
    println(String.format("All I want for Christmas is $ %s!", dollars))  // slowest
    println("All I want for Christmas is $ " + dollars + "!")
    println("All I want for Christmas is \$ $dollars!")
    println("""All I want for Christmas is ${'$'} $dollars!""")
    println("All I want for Christmas is \$ ${dollars + 100_000}!")
}
