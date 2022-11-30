package de.ostfale.kotlin.coroutines

import java.math.BigInteger
import kotlin.random.Random

val seq = sequence {
    print("Generating first ")
    yield(1)
    print("Generating second ")
    yield(2)
    print("Generating third ")
    yield(3)
    println("Done")
}


// fn=fn−1+fn−2 for n≥2 number is sum of predecessor and pre-predecessor f0=0 / f1=1
val fibonacci: Sequence<BigInteger> = sequence {
    var first = 0.toBigInteger()
    var second = 1.toBigInteger()
    while (true) {
        yield(first)
        val temp = first
        first += second
        second = temp
    }
}

fun randomNumbers(
    seed: Long = System.currentTimeMillis()
): Sequence<Int> = sequence {
    val random = Random(seed)
    while (true) {
        yield(random.nextInt())
    }
}

fun main() {
    for (num in seq) println(num)
    println(fibonacci.take(10).toList())
    println(randomNumbers().take(5).toList())
}
