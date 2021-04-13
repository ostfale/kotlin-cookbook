package de.ostfale.kotlin.datetime

import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime
import java.time.format.DateTimeFormatter

fun main() {
    stringToLocalDateTime()
    initWithDateTimeUsingOf()
}

fun initWithDateTimeUsingOf() {
    val birthday = LocalDate.of(1970, 7, 31)
    val startTime = LocalTime.of(20, 15)
    val dateTime = LocalDateTime.of(2021, 4, 13, 6, 46)
    println("Birthday: $birthday")
    println("Start: $startTime")
    println("Date and Time: $dateTime")
}


fun stringToLocalDateTime() {
    val s = "13.04.2021 06:38"
    val formatter = DateTimeFormatter.ofPattern("d.M.yyyy H:m")
    val dt1 = LocalDateTime.parse(s, formatter)
    println(dt1)
}