package de.ostfale.kotlin.generics.types

interface Geometry {
    fun area(): Int
}

data class Rectangle(val x: Int, val y: Int) : Geometry {
    override fun area() = x * y
}

class Storage1<T>(private val value: T) {
    val savedValue: T
        get() = value
}

fun main() {
    val s1a = Storage1(Rectangle(2, 3))
    println("Saved value ${s1a.savedValue}")
    // val s1b: Storage1<Geometry> = s1a type mismatch
}