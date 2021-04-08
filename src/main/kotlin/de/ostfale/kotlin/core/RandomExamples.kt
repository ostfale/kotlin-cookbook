package de.ostfale.kotlin.core

import kotlin.random.Random

fun main() {
    val n = (1..10).random()
    val c = ('A'..'Z').random()
    val data = arrayOf(2, 4, 6, 8).random()
    val d = Random.nextDouble()
    val dRange = Random.nextDouble(10.0, 30.0)
    val bool = (0..1).random() == 1

    println("Random number between 1-10 : $n")
    println("Random character between A-Z : $c")
    println("Random array member: $data")
    println("Random double: $d")
    println("Random double from range: $dRange")
    println("Random boolean : $bool")
}