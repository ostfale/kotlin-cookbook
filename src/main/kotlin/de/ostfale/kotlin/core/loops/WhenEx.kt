package de.ostfale.kotlin.core.loops

fun main() {
    simpleWhen()
    operatorWhen()
    println(datatypeWhen("test"))
    expressionWhen()
}

fun expressionWhen() {
    val x = 17
    when {
        x < 0 -> println("lower 0")
        x > 10 -> println("greater 10")
        else -> println("between 1..9")
    }
}

fun datatypeWhen(data: Any): String {
    return when (data) {
        is String -> "is string"
        is Int -> "is Int"
        is Long -> "is Long"
        else -> "I don't know"
    }
}


fun operatorWhen() {
    val i = 91
    val lst = listOf(25, 30, 35, 40)
    val result = when (i) {
        1, 3, in 5..10 -> "case 1"
        in lst -> "case 2"
        in 60..80, !in 90..100 -> "case 3"
        else -> "default"
    }
    println("Check conditions: $result")
}

fun simpleWhen() {
    val daysInMonth = when ((1..12).random()) {
        1, 3, 5, 7, 8, 10, 12 -> 31
        2 -> 28
        4, 6, 9, 11 -> 30
        else -> -1
    }
    println("Random days in Month: $daysInMonth")
}
