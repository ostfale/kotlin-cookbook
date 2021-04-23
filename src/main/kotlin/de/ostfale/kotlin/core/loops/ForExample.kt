package de.ostfale.kotlin.core.loops

fun main() {
    simpleFor()
    stepsFor()
    listFor()
    indicesFor()
    breakFor()
    continueFor()
}

fun continueFor() {
    for (i in 1..10) {
        if (i % 5 == 0) continue
        println("Continue: #$i")
    }
}

fun breakFor() {
    for (i in 1..10) {
        if (i > 3) break
        println("Before break: $i")
    }
}

fun indicesFor() {
    val numbers = listOf(2, 3, 5, 7)
    for ((idx, itm) in numbers.withIndex()) println("Element: $itm with index: $idx")

    val colors = mapOf("green" to 0x00ff00, "blue" to 0x0000ff, "white" to 0xffffff)
    for ((colName, colCode) in colors) println("Color name: $colName and code: $colCode")
}

fun listFor() {
    val colors = listOf("red", "green", "blue")
    for (c in colors) println("Color: $c")
}

fun stepsFor() {
    for (i in 1..10 step 3) println("With step: $i")
    for (i in 15 downTo 0 step 5) println("With downTo step: $i")
}

fun simpleFor() {
    for (i in 1..3) println(i)
    for (i in 0 until 5) println(i)
    for (i in 3 downTo 0) println(i)
}
