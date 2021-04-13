package de.ostfale.kotlin.datetime

import java.time.Month
import java.time.format.DateTimeFormatter
import java.util.*

fun main() {
    frenchMonthNames()
}

fun frenchMonthNames() {
    val frLoc = Locale("fr", "FR")
    val frFormatter = DateTimeFormatter.ofPattern("MMMM").withLocale(frLoc)
    for (m in (1..12)) {
        val mn = Month.of(m)
        println(frFormatter.format(mn))
    }
}
