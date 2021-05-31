package de.ostfale.kotlin.classes.delegation

class MyClass(val x: Int, val y: Int) {
    val z by lazy { complicatedCalc() }

    private fun complicatedCalc(): Int {
        println("calculate with first access")
        return x + y
    }
}