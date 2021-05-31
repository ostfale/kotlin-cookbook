package de.ostfale.kotlin.classes.delegation

class Person(val map: Map<String, Any?>) {
    private val id: Int by map
    private val name: String by map
    private val email: String by map

    override fun toString(): String {
        return "Person(id=$id, name='$name', email='$email')"
    }
}

class MutablePerson(val map: MutableMap<String, Any?>) {
    var id: Int by map
    var name: String by map
    var email: String by map
}

val someData = mapOf("name" to "Louis", "id" to 1, "email" to "ls@mail.de")

fun main() {
    val louis = Person(someData)
    println("Louis: $louis")
}