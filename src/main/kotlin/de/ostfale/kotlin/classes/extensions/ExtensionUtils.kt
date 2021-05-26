package de.ostfale.kotlin.classes.extensions

fun String?.stringOrEmpty() = this ?: ""
fun Int?.intOrO() = this ?: 0
fun Int?.intOrMinus1() = this ?: -1