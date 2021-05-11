package de.ostfale.kotlin.classes.constructor

class RectangleInit(length: Double, width: Double) {
    private var length: Double
    private var width: Double

    init {
        this.length = length
        this.width = width
    }

    fun area() = length * width
    fun perimeter() = (length + width) * 2
}

class RectangleDirectInit(length: Double, width: Double) {
    private var length: Double = length
    private var width: Double = width

    fun area() = length * width
    fun perimeter() = (length + width) * 2
}