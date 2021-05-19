package de.ostfale.kotlin.classes.inheritance

class MyClass {
    companion object : OtherClass() {
        fun myFun(x: Int, y: Int) = x * y
    }
}

open class OtherClass {
    fun otherFun(x: Int, y: Int) = x + y
}

fun main() {
    println(MyClass.myFun(2, 5))
    println(MyClass.otherFun(2, 5))
}