package de.ostfale.kotlin.classes.functions

fun String.upperFirstAndLast(): String {
   // val upperFirst = this.substring(0, 1).toUpperCase() + this.substring(1)
    val upperFirst = substring(0, 1).toUpperCase() + substring(1)
    return upperFirst.substring(0, upperFirst.length - 1) + upperFirst.substring(
        upperFirst.length - 1,
        upperFirst.length
    ).toUpperCase()
}

fun main() {
    println("this is a test".upperFirstAndLast())
}