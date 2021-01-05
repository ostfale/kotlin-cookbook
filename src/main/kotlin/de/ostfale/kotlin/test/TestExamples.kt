package de.ostfale.kotlin.test

class Santa(val title: String, val name: String) {

    fun getTitleAndName(): String = "$title $name"

    fun laugh(n: Int): String = "ho ".repeat(n).trim().capitalize()

    fun functionReturningUnit(): Unit {}
}

interface SantaI {
    fun getTitleAndName(): String
    fun laugh(n: Int): String
}