package de.ostfale.kotlin.datetime

import java.time.LocalDate

fun main() {
    isLeapYear()
    showLengthOfMonths()
}

private fun showLengthOfMonths() {
    for (m in (1..12)) {
        val myDate = LocalDate.now().withMonth(m)
        println("Month:  ${myDate.month} with # days: ${myDate.lengthOfMonth()}")
    }
}

private fun isLeapYear() {
    val date = LocalDate.now()
    println("Is ${date.year} a leap year: ${date.isLeapYear}")
}