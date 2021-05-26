package de.ostfale.kotlin.classes.interfaces

data class Rectangle(var length: Double, var width: Double) : Comparable<Rectangle> {
    override fun compareTo(other: Rectangle): Int {
        return this.getArea().compareTo(other.getArea())
    }

    private fun getArea() = length * width
}

fun main() {
    val r1 = Rectangle(2.0, 3.0)
    val r2 = Rectangle(2.4, 3.5)
    val r3 = Rectangle(1.8, 3.1)
    println("R2 > R3 : ${r2 > r3}")
    val lst = listOf(r1, r2, r3)
    println("Sorted: ${lst.sorted()}")
}