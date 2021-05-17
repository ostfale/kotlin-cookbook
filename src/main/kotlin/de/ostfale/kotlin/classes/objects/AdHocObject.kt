package de.ostfale.kotlin.classes.objects

val loginData = object {
    val host = "234.23.5.1"
    val login = "aUser"
    val password = "very secret"

    override fun toString(): String {
        return "Host: $host and Login: $login and password: $password"
    }
}

fun main() {
    println(loginData.toString())
}