package de.ostfale.kotlin.classes.exceptions

fun main() {
    println(getNumber("22"))
    println(useElvisOperator("22.5") ?: "Can't print the result!")
    println(useElvisOperator("22.5") ?: throw IllegalArgumentException("Number isn't an Int!!"))
}

fun useElvisOperator(str: String): Int? {
    return try {
        Integer.parseInt(str)
    } catch (e: NumberFormatException) {
        null
    } finally {
        println("I'm in the finally block....")
    }
}

fun getNumber(str: String): Int {
    return try {
        Integer.parseInt(str)
    } catch (e: NumberFormatException) {
        0
    } finally {
        println("I'm in the finally block....")
    }
}