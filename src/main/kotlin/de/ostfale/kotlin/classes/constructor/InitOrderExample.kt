package de.ostfale.kotlin.classes.constructor

class InitOrderClassExample(private val argA: Int, private val argB: String, argC: Double = 1.0) {
    val argC = argC
    private val argD: Int

    init {
        argD = argA * 3
    }

    val argE = argD + 5
    val argF: String

    init {
        argF = if (argB.length < 5) "short"
        else "long"
    }
}