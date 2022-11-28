package de.ostfale.kotlin.functional.ref

// if a function returns always the same output for the same input, input can be mapped directly to output (cached)
val input = listOf(setOf(1, 2, 3), setOf(3, 1, 2), setOf(2, 3, 1), setOf(4, 5, 6)) // first three have equal sum

// sum calculation as pure function (does not depend how often executed)
fun sum(numbers: Set<Int>): Double {
    return numbers.sumOf { it.toDouble() }
}

// stores the calculated result in a map
val resultsCache = mutableMapOf<Set<Int>, Double>()

// use sum method if not in cache (sum is pure function, summarizer not)
fun summarizer(): (Set<Int>) -> Double {
    val resultsCache = mutableMapOf<Set<Int>, Double>()

    return { numbers: Set<Int> ->
        resultsCache.computeIfAbsent(numbers, ::sum)
    }
}

fun main() {
    val summarizer = summarizer()
    input.forEach { println(summarizer(it)) }
}
