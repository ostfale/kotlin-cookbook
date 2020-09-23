package de.ostfale.kotlin.errors.tryexample

import de.ostfale.kotlin.core.ResourceReader

// https://medium.com/better-programming/do-you-even-try-functional-error-handling-in-kotlin-ad562b3b394f

fun main() {
    simpleErrorHandlingWithTry()
    firstPetExample()
}

fun simpleErrorHandlingWithTry() {
    val resultA: Try<String> = Try { "Hello functional World!" }
    val resultB: Try<String> = Try { throw Exception("Not Today!") }

    when (resultA) {
        is Success -> println(resultA.value)
        is Failure -> println(resultA.error.message)
    }

    when (resultB) {
        is Success -> println(resultB.value)
        is Failure -> println(resultB.error.message)
    }
}

fun firstPetExample() {
    val lines = Try {
        ResourceReader().readFileFromResources("./my-pet.csv").readLines().map { it.split(',') }
    }

    val petsWithoutTraverse: Try<List<Try<Pet>>> = lines.map { it.map(::toPet) }
    val petsWithTraverse: Try<List<Pet>> = lines.flatMap { Try.traverse(it, ::toPet) }
    val petsWithResultSet: Try<ResultSet<Pet>> = lines.map {
        it.map(::toPet).asResultSet().map { pet -> pet.copy(name = pet.name.toUpperCase()) }
    }

    when (petsWithoutTraverse) {
        is Success -> printTry(petsWithoutTraverse.value)
        is Failure -> println(petsWithoutTraverse.error)
    }

    when (petsWithTraverse) {
        is Success -> println("Traversing: " + petsWithTraverse.value)
        is Failure -> println("Traversing: " + petsWithTraverse.error)
    }


    when (petsWithResultSet) {
        is Success -> printResultSet(petsWithResultSet.value)
        is Failure -> println(petsWithResultSet.error)
    }
}

private fun printResultSet(resultSet: ResultSet<Pet>) {
    println("Printing a ResultSet: ")
    val successList: List<Success<Pet>> = resultSet.first
    val errorList: List<Failure<Pet>> = resultSet.second

    successList.forEach { it -> println(it.value) }
    errorList.forEach { it -> println(it.error) }
}

private fun printTry(tryList: List<Try<Pet>>) {
    println("Printing a Try: ")
    tryList.forEach { tryPet ->
        when (tryPet) {
            is Success -> println(tryPet.value)
            is Failure -> println(tryPet.error)
        }
    }

}