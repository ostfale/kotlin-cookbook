package de.ostfale.kotlin.classes.nested

class Outer {
    val x = "This is the outer class...!"
    private val myInner = Inner()

    class Nested {
        val y = "This is the nested class...!!"
        fun myFun() = "This is a nested Function!!"
    }

    inner class Inner {
        val y = "This is the inner class...!"
        fun myFun() = "This is the inner function....!"
        fun getX() = "The value of x = $x"
    }

    fun printAll() {
        val nested = Outer.Nested()
        println("From nested property: ${nested.y}")
        println("From nested function: ${nested.myFun()}")
        println("From inner property: ${myInner.y}")
        println("From inner property alternative: ${Outer().Inner().y}")
        println("From inner function: ${myInner.myFun()}")
        println("From inner func with ext. prop: ${myInner.getX()}")
    }
}

fun main() {
    Outer().printAll()
}