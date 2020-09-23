package de.ostfale.kotlin.classes.objects

interface SomeInterface {
    fun mustImplement(num: Int): String
}

fun wantsSomeInterface(si: SomeInterface) {
    println("Printing from wantsSomeInterface ${si.mustImplement(42)}")
}

fun main() {
    wantsSomeInterface(object : SomeInterface {
        override fun mustImplement(num: Int) = "This is from mustImplement: ${num + 100}"
    })
}