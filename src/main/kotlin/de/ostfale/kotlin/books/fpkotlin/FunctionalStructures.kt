package de.ostfale.kotlin.books.fpkotlin


data class Cons<out A>(val head: A, val tail: List<A>) : List<A>()
object Nil : List<Nothing>()

sealed class List<out A> {

    companion object {
        fun <A> of(vararg aa: A): List<A> {
            val tail = aa.sliceArray(1 until aa.size)

            return if (aa.isEmpty()) {
                Nil
            } else {
                Cons(aa[0], of(*tail))
            }
        }

        fun sum(intList: List<Int>): Int =
            when (intList) {
                is Nil -> 0
                is Cons -> intList.head + sum(intList.tail)
            }

        fun product(doubleList: List<Double>): Double =
            when (doubleList) {
                is Nil -> 1.0
                is Cons -> {
                    if (doubleList.head == 0.0) 0.0
                    else doubleList.head * product(doubleList.tail)
                }
            }
    }
}

// some convenience functions as extensions ex.3.1 / 3.2
fun <A> List<A>.tail(): List<A> =
    when (this) {
        is Cons -> this.tail
        is Nil -> throw IllegalStateException("Nil can't have a tail")
    }

fun <A> List<A>.setHead(x: A): List<A> =
    when (this) {
        is Cons -> Cons(x, this.tail)
        is Nil -> throw IllegalStateException("Cannot replace Head of a Nil list!")
    }

fun main() {
    // simple single linked list from varargs
    val intList = List.of(1, 2, 3, 4, 5)
    val doubleList = List.of(1.0, 2.5, 3.1, 4.4, 5.6)
    println(intList)
    println(List.sum(intList))
    println(List.product(doubleList))

    println("Extension tail before: $intList and after tail function\n: ${intList.tail()}")
    println("Extension set Head before: $intList and after setHead function\n: ${intList.setHead(666)}")
}