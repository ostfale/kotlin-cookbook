package de.ostfale.kotlin.generics.types

import java.time.LocalDateTime

class Logger1<T> {
    fun log(data: T) {
        println(LocalDateTime.now())
        println(data)
    }
}

class Logger2<in T> {
    fun log(data: T) {
        println(LocalDateTime.now())
        println(data)
    }
}

fun main() {
    val log1a = Logger1<Geometry>()
    val log2a = Logger2<Geometry>()
    log1a.log(Rectangle(2, 4))
    log2a.log(Rectangle(2, 4))
    // val log1b: Logger1<Rectangle> = log1a type mismatch
    val log2b: Logger2<Rectangle> = log2a
    println("Contravariance: ${log2b.log(Rectangle(2, 4))}")
}