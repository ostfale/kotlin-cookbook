package de.ostfale.kotlin.classes.delegation

interface Geometry {
    fun area(): Int
    fun perimeter(): Int
}

open class Rectangle(val w: Int, val h: Int) : Geometry {
    override fun area() = w * h
    override fun perimeter() = (w + h) / 2
}

// version 1 inheritance
class WindowInherited(val posX: Int, val posY: Int, bounds: Rectangle) : Rectangle(bounds.w, bounds.h)

// implement interface
class WindowImplInterface(val x: Int, val y: Int, private val bounds: Rectangle) : Geometry {
    override fun area() = bounds.area()
    override fun perimeter() = bounds.perimeter()
}

// use delegation
class WindowDelegate(val x: Int, val y: Int, private val bounds: Rectangle) : Geometry by bounds

fun main() {
    val w1 = WindowInherited(70, 30, Rectangle(200, 100))
    val w2 = WindowImplInterface(70, 30, Rectangle(300, 100))
    val w3 = WindowDelegate(70, 30, Rectangle(50, 50))
    println("Window inherited area: ${w1.area()} \n Window interface area: ${w2.area()} \n Window delegate: ${w3.area()}")
}