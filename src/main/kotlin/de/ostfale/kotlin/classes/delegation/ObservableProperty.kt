package de.ostfale.kotlin.classes.delegation

import kotlin.properties.Delegates.observable

class MyClassObservable(x: Int, y: Int) {

    var x: Int by observable(x) { _, old, new ->
        println("x is now: $new from $old")
    }

    var y: Int by observable(y) { prop, old, new ->
        println("y is now: $new from $old")
    }

    override fun toString() = "MyClassObservable(x=$x , y = $y)"
}

fun main() {
    val mc = MyClassObservable(1, 2)
    println("Before change $mc")
    mc.y = 4
    mc.x = 3
    println("After change $mc")
}