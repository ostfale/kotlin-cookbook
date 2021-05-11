package de.ostfale.kotlin.classes.constructor

class Rectangle(var length: Double, var width: Double) {
    fun area() = length * width
    fun perimeter() = (length + width) * 2
}