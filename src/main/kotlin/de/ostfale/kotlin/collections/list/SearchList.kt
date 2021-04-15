package de.ostfale.kotlin.collections.list

fun main() {
    simpleSearch()
    stringSearch()
}

fun stringSearch() {
    val s = "Lorem ipsum dolor sit amet consetetur sadipscing elitr"
    val lst = s.split(" ")
    val res = lst.find { it -> it.length > 6 }
    println("Index of 'sit' : ${lst.indexOf("sit")}")  // 3
    println("Index of 'abc' : ${lst.indexOf("abc")}") // -1
    println("First word > 6 char: $res")
}

private fun simpleSearch() {
    val lst = listOf(1, 4, 7)
    println("Is 3 in list: ${3 in lst}")
}