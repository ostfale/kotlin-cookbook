package de.ostfale.kotlin.functional.sealed

// https://medium.com/livefront/sealed-enum-replacing-enums-in-kotlin-4c513e7e8db

// GitHub : https://github.com/livefront/sealed-enum

interface SealedEnum<T> : Comparator<T> {

    val values: List<T>

    fun ordinalOf(obj: T): Int

    fun nameOf(obj: T): String

    fun valueOf(name: String): T

    override fun compare(first: T, second: T) = ordinalOf(first) - ordinalOf(second)
}