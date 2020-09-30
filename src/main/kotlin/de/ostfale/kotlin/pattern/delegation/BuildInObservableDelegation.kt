package de.ostfale.kotlin.pattern.delegation

import kotlin.properties.Delegates.observable

fun main() {
    println("The value of count is: $count")
    count++
    println("The value of count is: $count")
    count--
    println("The value of count is: $count")
}

var count by observable(0) { property, oldValue, newValue -> println("Property: $property old: $oldValue new: $newValue") }



