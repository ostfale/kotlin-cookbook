package de.ostfale.kotlin.functional.inlineEx

fun main() {
    val a = 2.0
    val result = embed({ x -> x * x }, { x -> x + 3 }, a)
    val resultGeneric = embedGeneric({ x -> x * x }, { x -> x + 3 }, a)
    println("Inline function result: $result")
    println("Generic inline function result: $resultGeneric")
}

inline fun <T> embedGeneric(
    f1: (param: T) -> T,
    f2: (param: T) -> T,
    x: T
): T {
    return f1(f2(x))
}

inline fun embed(
    f1: (param: Double) -> Double,
    f2: (param: Double) -> Double,
    x: Double
): Double {
    return f1(f2(x))
}

// with noinline the second function can be reused
inline fun embedAlternative(
    f1: (param: Double) -> Double,
    noinline f2: (param: Double) -> Double,
    x: Double
): Double {
    val innerFunc = f2
    return f1(innerFunc(x))
}