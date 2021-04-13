package de.ostfale.kotlin.core.strings

import kotlin.math.sin
import kotlin.math.sqrt

// https://kotlin.christmas/2020/6

fun main() {
    concatEx()
    rawTextEx()
    stringMethodsEx()
    compareString()
    formatStringsEx()
    formattingExamples()
}

fun formatStringsEx() {
    println(" n    sqrt(n)   sin(n)")
    println("----------------------")
    for (i in 8..12) {
        val f = i.toDouble()
        val fmt = "%2d    %6.3f    %6.3f"
        val s = fmt.format(i, sqrt(f), sin(f))
        println(s)
    }
}

fun stringMethodsEx() {
    val s = "Lorem ipsum dolor sit amet"
    val b = "abc"
    println("\nLength: ${s.length}\n")
    println("Show first char: ${s[0]}")
    for (c in b) println("char: $c")
}

fun compareString() {
    val u = "Louis"
    val u1 = "louis"
    println("Equals with ignore: ${u.equals(u1, ignoreCase = true)}")
    println("Equals without ignore: ${u == u1}")
}

fun rawTextEx() {
    val file = """c:\some directory\someFile.java"""
    val twoLines = """
        line one
        line two
    """.trimIndent()

    val mail = "meier@mail.com"
    val sql = """
        SELECT * FROM table
        WHERE mail = '$mail'
    """.trimIndent()

    println("Name of the file: $file")
    println("Two lines: $twoLines")
    println("Raw + Interpolation: $sql")
}

fun concatEx() {
    val s = "abc"
    val t = s + 1 + 2 + 3.14 + 'x'

    println("Sum of different types: $t")
}


fun formattingExamples() {
    val dollars = 100.00
    println(String.format("\nAll I want for Christmas is $ %s!", dollars))  // slowest
    println("All I want for Christmas is $ " + dollars + "!")
    println("All I want for Christmas is \$ $dollars!")
    println("""All I want for Christmas is ${'$'} $dollars!""")
    println("All I want for Christmas is \$ ${dollars + 100_000}!")
}
