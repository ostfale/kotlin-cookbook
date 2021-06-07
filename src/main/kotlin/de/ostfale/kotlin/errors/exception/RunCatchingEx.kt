package de.ostfale.kotlin.errors.exception

fun main() {
    val result = runCatching {
        val tmp = (0..200).random()
        if (tmp > 100) throw Exception("Too large")
        tmp
    }

    println("Success: ${result.isSuccess}")
    println("Failure: ${result.isFailure}")
    if (result.isSuccess) println("Result: ${result.getOrThrow()}")
    if (result.isFailure) println("Result: ${result.exceptionOrNull()}")
}