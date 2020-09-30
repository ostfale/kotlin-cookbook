package de.ostfale.kotlin.pattern.delegation

import kotlin.properties.Delegates

fun main() {
    println("The value of count is: $countVeto")
    countVeto++
    println("The value of count is: $countVeto")
    countVeto--
    println("The value of count is: $countVeto")
}

var countVeto by Delegates.vetoable(0) { _, oldValue, newValue -> newValue > oldValue }