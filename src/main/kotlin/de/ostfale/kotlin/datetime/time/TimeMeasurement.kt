package de.ostfale.kotlin.datetime.time

import kotlin.time.measureTimedValue

@kotlin.time.ExperimentalTime
fun main() {

    var result : List<Int>
    val (value, duration) = measureTimedValue {
        result = (calculatePrime(200))
    }
    println("Prime with copyright: ${Typography.copyright} numbers $result}")
    println("Time taken: ${duration.toIsoString()}")

}

fun calculatePrime(number: Int): List<Int> {
    val primeList = mutableListOf<Int>()
    for (i in 1..number) {
        if (isPrime(i)) {
            primeList.add(i)
        }
    }
    return primeList
}

private fun isPrime(n: Int): Boolean {
    return n > 1 && (2..n / 2).none { n % it == 0 }
}
