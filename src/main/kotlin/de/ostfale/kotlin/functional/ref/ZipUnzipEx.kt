package de.ostfale.kotlin.functional.ref

fun main() {
    zipUnzipEx()
    zipWithNextEx()
}

fun zipWithNextEx() {
    val lst = List(10) { it }
    val lst1 = lst.zipWithNext { a, b -> a * b }
    println("ZipWithNext of a list: $lst1")
}

fun zipUnzipEx() {
    val lst1 = List(10) { it } // [0,1,..9]
    val lst2 = "ABCDEFGHIJKLMN".toList() // ['A','B',...]
    val lst3 = lst1.zip(lst2) // List<Pair<Int,Char>>
    println("Combined list: $lst3")
    val (lst4, lst5) = lst3.unzip()
    println("Destructuring of the Pair list to 2 singe lists: lst4 : $lst4 and lst5: $lst5")
}
