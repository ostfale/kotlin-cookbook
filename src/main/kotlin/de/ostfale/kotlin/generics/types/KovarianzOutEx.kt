package de.ostfale.kotlin.generics.types

class Storage2<out T>(private val value: T) {
    val savedVal: T
        get() = value
}

fun main() {
    val s2a = Storage2(Rectangle(8, 6))
    val s2b: Storage2<Geometry> = s2a
    println("Covariant object: ${s2b.savedVal}")
}