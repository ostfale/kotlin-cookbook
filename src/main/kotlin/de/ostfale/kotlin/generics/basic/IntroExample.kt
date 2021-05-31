package de.ostfale.kotlin.generics.basic

class MyTriple<T>(val a: T, val b: T, val c: T) {
    override fun toString(): String {
        return "MyTriple(a=$a, b=$b, c=$c)"
    }
}

fun main() {
    val t1 = MyTriple(1, 2, 3)
    val t2 = MyTriple(1.3, 2.4, 5.5)
    val t3 = MyTriple("a", "b", "c")
    println("Results are: $t1 and $t2 and $t3")
}