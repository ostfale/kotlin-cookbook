@file:OptIn(ExperimentalTime::class)

package de.ostfale.kotlin.datetime

import kotlin.time.Duration
import kotlin.time.ExperimentalTime

// https://lengrand.fr/measuring-time-and-durations-in-kotlin/

val tenDays: Duration = Duration.days(10)
val fiveNanoSeconds = Duration.nanoseconds(5)

fun main() {
    println("These are ten days and five nanoseconds: ${tenDays + fiveNanoSeconds}")
}


fun <A> findFirst(xs: Array<A>, p: (A) -> Boolean): Int {
    tailrec fun loop(n: Int): Int =
        when {
            n >= xs.size -> -1
            p(xs[n]) -> n
            else -> loop(n + 1)
        }
    return loop(0)
}