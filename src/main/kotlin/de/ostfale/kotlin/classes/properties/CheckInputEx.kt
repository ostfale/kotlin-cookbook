package de.ostfale.kotlin.classes.properties

class Rectangle(length: Double, width: Double) {
    var length = 0.0
        get() = field  // redundant
        set(value) {
            if (value <= 0)
                throw IllegalArgumentException("length must be > 0")
            field = value
        }

    var width = 0.0
        get() = field  // redundant
        set(value) {
            if (value <= 0)
                throw IllegalArgumentException("width must be > 0")
            field = value
        }

    init {
        this.length = length
        this.width = width
    }
}

fun main() {
    val rec = Rectangle(2.7, 0.5)
    rec.width = -3.0
}