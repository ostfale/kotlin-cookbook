package de.ostfale.kotlin.functional.extensions.scope

// https://kotlin.christmas/2020/3

data class User(val name: String, val age: Int)

val user = User("Santa", 1748)

fun main() {
    println(user.let { it -> it.name })     // Santa
    println(user.run { name })              // Santa
    println(user.apply { name })            // User(name=Santa, age=1748)
    println(user.also { it.name })          // User(name=Santa, age=1748)
}