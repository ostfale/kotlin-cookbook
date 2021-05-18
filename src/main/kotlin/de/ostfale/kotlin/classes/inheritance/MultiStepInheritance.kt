package de.ostfale.kotlin.classes.inheritance

open class A(val prop1: Int)
open class B(prop1: Int, val prop2: Double) : A(prop1)
class C(prop1: Int, prop2: Double, val prop3: String) : B(prop1, prop2)

fun main() {
    val obj = C(1, 2.5, "house")
    println("Result: ${obj.prop1}")
}