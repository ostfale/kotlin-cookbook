package de.ostfale.kotlin.datetime

import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime
import java.time.format.DateTimeFormatter
import java.time.format.FormatStyle

// https://www.ict.social/kotlin/oop/date-and-time-in-kotlin-creating-and-formatting

// current date and time
val instDateTime: LocalDateTime = LocalDateTime.now()

// current date
val instDate: LocalDate = LocalDate.now()

// Current time
val instTime: LocalTime = LocalTime.now()

fun main() {
    println("Date time from current instance: $instDateTime")
    println("Date from current instance: $instDate")
    println("Time from current instance: $instTime")
    println("\n++++ Formatting +++++")
    println("Format style medium: ${instDateTime.format(DateTimeFormatter.ofLocalizedTime(FormatStyle.MEDIUM))}")
    println("Format style full: ${instDateTime.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL))}")
    println(
        "Format style short: ${
            instDateTime.format(
                DateTimeFormatter.ofLocalizedDateTime(
                    FormatStyle.LONG,
                    FormatStyle.SHORT
                )
            )
        }"
    )
    println("Format style pattern: ${instDateTime.format(DateTimeFormatter.ofPattern("M/d/y H:m:ss"))}")
}