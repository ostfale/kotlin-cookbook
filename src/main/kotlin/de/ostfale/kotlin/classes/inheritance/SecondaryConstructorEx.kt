package de.ostfale.kotlin.classes.inheritance

open class ASecConstructor(val p1: Int, val p2: Int)
class BSecConstructor : ASecConstructor {
    private val p3: Int

    constructor(p1: Int, p2: Int, p3: Int) : super(p1, p2) {
        this.p3 = p3
    }

    constructor(p: Int) : super(p, p) {
        p3 = 0
    }

    constructor() : super(0, 0) {
        p3 = 0
    }
}

fun main() {
    val obj1 = BSecConstructor(1, 2, 3)
    val obj2 = BSecConstructor(12)
    val obj3 = BSecConstructor()
}