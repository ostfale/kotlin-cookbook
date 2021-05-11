package de.ostfale.kotlin.classes.constructor

class IntRectangle {
    private val length: Int
    private val width: Int

    constructor(l: Int, b: Int) {
        this.length = l
        this.width = b
    }

    constructor(s: String) {
        val parts = s.split("x")
        this.length = 1
        this.width = 2
    }
}