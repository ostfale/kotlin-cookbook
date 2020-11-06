package de.ostfale.kotlin.datetime

import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime
import java.time.Month

// https://www.ict.social/kotlin/oop/date-and-time-in-kotlin-creating-and-formatting

// date and time
val dateTime: LocalDateTime = LocalDateTime.of(2020, Month.OCTOBER, 17, 18, 3)

// date only
val localDate: LocalDate = LocalDate.of(2020, Month.OCTOBER, 17)

// time only
val localTime: LocalTime = LocalTime.of(18, 10, 10)

fun main() {
    println("Local date time from given value: $dateTime")
    println("Local date  from given value: $localDate")
    println("Local time  from given value: $localTime")
}