package de.ostfale.kotlin.functional.lambda

fun main() {
    simpleEx()
    starEx()
}

fun starEx() {
    val lst = listOf(1, 2, 3, 4)
    val res = lst.map { "*".repeat(it) }
    println("Create stars for number: $res")
}

fun simpleEx() {
    val quad: (Int) -> Int = { x -> x * x }
    val lst = listOf(1, 2, 3, 4)
    val res1: List<Int> = lst.map(quad)
    val res2: List<(Int) -> Int> = lst.map { quad }
    val res3: List<Int> = lst.map { quad.invoke(it) }
    println("Lambda as argument (): $res1")
    println("Lambda as argument {}: $res2")
    println("Lambda as argument invoke {}: $res3")
}
