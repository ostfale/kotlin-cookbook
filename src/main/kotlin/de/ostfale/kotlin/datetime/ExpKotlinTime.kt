package de.ostfale.kotlin.datetime

import kotlin.math.sin
import kotlin.time.ExperimentalTime
import kotlin.time.TimeSource
import kotlin.time.measureTime

fun main() {
    useMonotonic()
    measureTimeExample()
}

@OptIn(ExperimentalTime::class)
fun measureTimeExample() {
    val duration = measureTime {
        for (i in (0..1_000_000)) sin(i.toDouble())
    }
    println("Lambda measureTime result: $duration")
}

@OptIn(ExperimentalTime::class)
fun useMonotonic() {
    val now = TimeSource.Monotonic.markNow()
    for (i in (0..1_000_000)) sin(i.toDouble())
    val dur = now.elapsedNow()
    println("Duration: $dur")
}
