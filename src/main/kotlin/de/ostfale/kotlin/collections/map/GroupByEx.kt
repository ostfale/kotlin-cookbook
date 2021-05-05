package de.ostfale.kotlin.collections.map

fun main() {
    val result = persons.groupBy { it.city }
    println("Persons comming from: $result")
}

data class Person(val name: String, val city: String) {
    override fun toString() = "$name from $city"
}

val persons = listOf(
    Person("Michael", "Graz"),
    Person("Louis", "Buchholz"),
    Person("Eva", "Buchholz"),
    Person("Marie-Christin", "Paris"),
    Person("Laura", "London"),
)