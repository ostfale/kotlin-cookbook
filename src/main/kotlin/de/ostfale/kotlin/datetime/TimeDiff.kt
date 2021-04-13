package de.ostfale.kotlin.datetime

import java.time.Duration
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.temporal.ChronoUnit

fun main() {
    workTimeFromTo()
    durationInOneUnit()
}

fun durationInOneUnit() {
    val jeffStart = LocalDate.of(1801, 3, 4)
    val jeffEnd = LocalDate.of(1809, 3, 4)
    val days = ChronoUnit.DAYS.between(jeffStart, jeffEnd)
    println("Thomas Jefferson was $days days US president")
}

fun workTimeFromTo() {
    val startWork = LocalDateTime.of(2020, 12, 1, 8, 0)
    val endWork = LocalDateTime.of(2020, 12, 1, 16, 15)
    val workHours = Duration.between(startWork, endWork)
    val hours = workHours.toMinutes() / 60.0
    println("Working time in hours: %2f".format(hours))
}
