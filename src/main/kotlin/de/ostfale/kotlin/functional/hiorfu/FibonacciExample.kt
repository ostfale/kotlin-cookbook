package de.ostfale.kotlin.functional.hiorfu

fun fib(i: Int): Int {
    fun go(n: Int, current: Int, next: Int): Int {
        return when (n) {
            0 -> current
            else -> go(n - 1, next, current + next)
        }
    }
    return go(i, 0, 1)
}

fun fibBook(i: Int): Int {
    tailrec fun go(cnt: Int, curr: Int, nxt: Int): Int =
        if (cnt == 0)
            curr
        else go(cnt - 1, nxt, curr + nxt)
    return go(i, 0, 1)
}

fun main() {
    println(fib(20))
    println(fibBook(30))
}