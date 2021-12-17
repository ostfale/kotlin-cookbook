package de.ostfale.kotlin.classes.typeclass

import java.math.BigDecimal

// https://kotlin.christmas/2020/7

interface Addable<T> {
    fun T.plus(t: T): T
    fun zero(): T

    companion object {
        fun <T> instance(plus: (T, T) -> T, zero: () -> T): Addable<T> {
            return object : Addable<T> {
                override fun T.plus(t: T) = plus(this, t)
                override fun zero(): T = zero()
            }
        }
    }
}

fun <T> Iterable<T>.sum(addable: Addable<T>): T {
    var sum: T = addable.zero()
    for (element in this) {
        addable.run {
            sum = sum.plus(element)
        }
    }
    return sum
}

fun bigDecimalAddable(): Addable<BigDecimal> =
    Addable.instance({ a, b -> a + b },  { BigDecimal(0) })

fun main() {
    println(listOf(BigDecimal(1), BigDecimal(2), BigDecimal(3)).sum(bigDecimalAddable()))
}