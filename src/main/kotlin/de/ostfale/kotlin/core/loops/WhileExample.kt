package de.ostfale.kotlin.core.loops

fun main() {
    basicWhile()
    doWhileEx()
}

fun doWhileEx() {
    var i = 1
    do {
        println("Do while: $i")
        i *= 3
    } while (i < 100_000)
}

fun basicWhile() {
    var i = 1
    while (i < 50_000) {
        println("Simple while :  $i")
        i *= 2
    }
}
