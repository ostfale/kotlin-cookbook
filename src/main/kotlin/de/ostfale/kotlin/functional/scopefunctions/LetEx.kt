package de.ostfale.kotlin.functional.scopefunctions

fun main() {
    simpleLetEx()
}

fun simpleLetEx() {
    val mariaHuber = Student(1232, "Huber, Maria")
    val ok: String = mariaHuber.let {
        it.majorSubject = "Biology"
        it.toString()
    }
    println("Returned value: $ok")
}


