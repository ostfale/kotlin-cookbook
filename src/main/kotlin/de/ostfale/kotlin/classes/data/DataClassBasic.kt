package de.ostfale.kotlin.classes.data

data class Contact(val name: String, val address: String, val email: String)

fun main() {
    deconstructionEx()
    copyEx()
}

fun copyEx() {
    val c = Contact("Terry", "Prag", "t@mail.com")
    val cc = c.copy(name = "Edgar")
    println("Copied object: $cc")
}

fun deconstructionEx() {
    val c = Contact("Terry", "Prag", "t@mail.com")
    val (name, address, email) = c
    println("Name: $name - address: $address - email: $email")
}
