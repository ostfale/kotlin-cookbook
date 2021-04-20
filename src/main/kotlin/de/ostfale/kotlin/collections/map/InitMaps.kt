package de.ostfale.kotlin.collections.map

fun main() {
    initMap()
    initMutableMap()
}

data class Book(val name: String, val author: String)

fun initMutableMap() {
    val books = mutableMapOf<String, Book>()
    books["isbn1"] = Book("Raspberry Pi", "Kofler")
    books["isbn2"] = Book("Docker", "Öggl")
    for ((isbn, book) in books) println("ISBN: $isbn : ${book.name}")
}

fun initMap() {
    val colors = mapOf("green" to 0x00ff00, "blue" to 0x0000ff, "white" to 0xffffff)
    val blueInColors = "blue" in colors
    println("%06x".format(colors["green"]))
    println("Is blue in colors: $blueInColors")
    println("Color keys: ${colors.keys}")
    println("Color values: ${colors.values}")
}
