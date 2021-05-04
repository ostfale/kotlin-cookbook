package de.ostfale.kotlin.functional.ref

import kotlin.math.sqrt

fun main() {
    val lst = listOf(2, 7, 9, 13, 4, 19, 8)
    lst.forEach {
        val x = sqrt(it.toDouble())
        println("Sqrt of $it : $x")
    }
}