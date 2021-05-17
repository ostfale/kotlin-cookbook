package de.ostfale.kotlin.classes.properties

class MyPropsClass(var a: Int, var b: Int, private var c: Int, private var d: Int) {
    fun m1() = a + b + c + d
    fun m2(): Int {
        return if (a > b) m1() else m3()
    }

    private fun m3() = a * b * c * d
    private fun m4() = 2 * m1()
}

fun main() {
    val myObject = MyPropsClass(1, 2, 3, 4)
    println(myObject.a)     // 1
    println(myObject.b)     // 2
    // println(myObject.c)     // Error - no access
    // println(myObject.d)     // Error - no access
    println(myObject.m1())    // 10
    println(myObject.m2())    // 24
    //  println(myObject.m3())    // Error - no access
    //  println(myObject.m4())    // Error - no access
}