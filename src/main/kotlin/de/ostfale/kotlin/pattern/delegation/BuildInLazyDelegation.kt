package de.ostfale.kotlin.pattern.delegation

fun getTemperature(city: String): Double {
    println("Fetch data from webservice for $city")
    return 30.0
}

val temperature by lazy { getTemperature("Hamburg") }

fun main() {
    latestTemperatureStatement(false)
    latestTemperatureStatement(true)
}

private fun latestTemperatureStatement(showTemperature: Boolean) {
    if (showTemperature && temperature > 20) {
        println("It's warm")
    } else {
        println("Nothing to report")
    }
}