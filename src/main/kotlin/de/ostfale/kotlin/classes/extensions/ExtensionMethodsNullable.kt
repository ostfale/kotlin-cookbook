package de.ostfale.kotlin.classes.extensions

fun String?.left(n: Int) =
    this?.substring(0, n) ?: ""

fun main() {
    val s = "abc"
    val t = null
    println("Not null: ${s.left(1)} ")
    println("With null: ${t.left(1)} ")
}