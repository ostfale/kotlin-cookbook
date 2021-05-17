package de.ostfale.kotlin.classes.objects

interface Geometry {
    fun getArea(): Double
}

val rightTriangle = object : Geometry {
    val a = 4.5
    val b = 2.4
    override fun getArea() = a * b / 2.0
}

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