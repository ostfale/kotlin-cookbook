package de.ostfale.kotlin.functional.sam

// https://kotlin.christmas/2020/21

val uppercaseFn: (String) -> String = { it.toUpperCase() }  // simple lambda function
typealias Uppercase = (String) -> String

val uppercaseFn1: Uppercase = { it.toUpperCase() } // using typealias for lambda

// functional interface
fun interface Suffix {
    fun exclaim(s: String): String
}

val suffixFn: Suffix = Suffix { "$it!" }
fun doStuff(fn: Suffix) = fn.exclaim("Hello again")


// using invoke
fun interface Prefix {
    operator fun invoke(s: String): String
}

val prefixFn: Prefix = Prefix { "~$it" }

// return functions from FI
fun interface Math {
    fun value(s: Int): (Int) -> Int
}

val timesX = Math { times -> { it * times } }
val timesTwo = timesX.value(2)

fun main() {
    println(uppercaseFn("This is all in uppercase via lambda!"))
    println(uppercaseFn1("This is the same with a typealias all in uppercase via lambda!"))
    println(suffixFn.exclaim("Hello with an exclamation mark now"))
    println(doStuff(suffixFn))
    println(prefixFn("Hello Prefix"))
    println(timesTwo(5)) // 10
}