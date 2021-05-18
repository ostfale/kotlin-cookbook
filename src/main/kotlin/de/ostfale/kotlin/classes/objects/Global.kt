package de.ostfale.kotlin.classes.objects

import java.time.Duration
import java.time.LocalTime

// example for top-leve (global) functions
private val initTime = LocalTime.now()
private var count = 0

fun getTimeSinceStart() = Duration.between(initTime, LocalTime.now()).toMillis()
fun incrementAndGetCounter(): Int {
    count += 1
    return count
}

fun main() {
    println("Time since start in ms: ${getTimeSinceStart()}")
}