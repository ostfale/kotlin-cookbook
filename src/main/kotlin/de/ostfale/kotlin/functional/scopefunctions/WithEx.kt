package de.ostfale.kotlin.functional.scopefunctions

fun main() {
    simpleWith()
}

fun simpleWith() {
    val mariaHuber = Student(12345, "Huber, Maria")
    with(mariaHuber) {
        address = "Buchholz,Friedrichstraße"
        birthYear = 1999
        majorSubject = "Astrophysics"
    }
}

data class Student(
    val id: Int,
    val name: String,
    var address: String? = "",
    var birthYear: Int? = 0,
    var majorSubject: String? = ""
)