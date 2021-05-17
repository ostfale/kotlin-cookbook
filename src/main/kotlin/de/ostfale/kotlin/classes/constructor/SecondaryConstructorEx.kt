package de.ostfale.kotlin.classes.constructor

class RectangleSecCon(var length: Double, var width: Double) {
    // secondary constructor for squares
    constructor(side: Double) : this(side, side)

    // secondary constructor for squares with length 1
    constructor() : this(1.0)

    fun area() = length * width
    fun perimeter() = (length + width) / 2
}

