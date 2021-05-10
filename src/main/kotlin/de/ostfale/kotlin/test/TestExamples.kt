package de.ostfale.kotlin.test

import java.util.*

class Santa(val title: String, val name: String) {

    fun getTitleAndName(): String = "$title $name"

    fun laugh(n: Int): String = "ho ".repeat(n).trim()
        .replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() }

    fun functionReturningUnit(): Unit {}
}

interface SantaI {
    fun getTitleAndName(): String
    fun laugh(n: Int): String
}