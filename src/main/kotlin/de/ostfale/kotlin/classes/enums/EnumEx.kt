package de.ostfale.kotlin.classes.enums

enum class Months(val no: Int) {
    January(1), February(2), March(3)
}

fun main() {
    Months.values().forEach { println(it.name) }
    println("ValueOf: ${Months.valueOf("March")}")
}