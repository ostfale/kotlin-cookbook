package de.ostfale.kotlin.classes.inheritance

open class A1(private val prop1: Int, private val prop2: Int) {
    open fun m() = prop1 + prop2
}

class B1(private val prop1: Int, private val prop2: Int, private val prop3: Int) : A1(prop1, prop2) {
    override fun m() = prop1 + prop2 + prop3
    fun mSuper() = super.m() + prop3
}

fun main() {
    val obj = B1(1, 2, 7)
    println("m: ${obj.m()}")
    println("m-super: ${obj.mSuper()}")
}