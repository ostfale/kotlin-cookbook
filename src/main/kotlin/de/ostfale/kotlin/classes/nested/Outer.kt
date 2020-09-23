package de.ostfale.kotlin.classes.nested

import org.slf4j.LoggerFactory

class Outer {

    private val log = LoggerFactory.getLogger(javaClass)

    val x = "This is the outer class...!"
    val myInner = Inner()

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
        log.info(nested.y)
        log.info(nested.myFun())
        val inner = Outer().Inner()
        log.info(inner.y)
        log.info(inner.myFun())
        log.info(inner.getX())
    }
}

fun main() {
    Outer().printAll()
}