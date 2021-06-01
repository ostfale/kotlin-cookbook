package de.ostfale.kotlin.generics.basic

fun <T> MutableList<T>.removeFirst(): T? {
    return if (this.size == 0) return null
    else this.removeAt(0)
}

fun <T> MutableList<T>.removeLast(): T? {
    return if (this.size == 0) return null
    else this.removeAt(this.size - 1)
}

fun main() {
    val lst = MutableList(10) { it }
    println("Removed first from list: ${lst.removeFirst()}  and, of course, the last element: ${lst.removeLast()}")
}