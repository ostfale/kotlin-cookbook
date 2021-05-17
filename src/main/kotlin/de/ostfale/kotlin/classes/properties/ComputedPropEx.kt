package de.ostfale.kotlin.classes.properties

class RectangleCompProp(length: Double, width: Double) {
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

    val isSquare
        get() = length == width
}

fun main() {
    val rec = RectangleCompProp(2.7, 0.5)
    println("Is square: ${rec.isSquare}")
}