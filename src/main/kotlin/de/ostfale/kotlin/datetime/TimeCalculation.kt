package de.ostfale.kotlin.datetime

import java.time.LocalDate
import java.time.LocalTime

fun main() {
    addSubtractTime()
}

fun addSubtractTime() {
    val now = LocalTime.now()
    val soon = now.plusHours(1)
    val before = now.minusMinutes(30)
    println("Now : $now - Soon: $soon  and before Soon: $before")
    val today = LocalDate.now()
    val inAWeek = today.plusDays(7)
    val inAYear = today.plusYears(1)
    println("Today: $today - in a Week: $inAWeek - in a Year: $inAYear")
}
