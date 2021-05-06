package de.ostfale.kotlin.functional.scopefunctions

fun main() {
    simpleApplyEx()
}

fun simpleApplyEx() {
    var mariaHuber = Student(122334, "Maria Huber").apply {
        address = "Winchester 77"
        birthYear = 2002
        majorSubject = "History"
    }
}
