package de.ostfale.kotlin.books.fpkotlin


data class Cons<out A>(val head: A, val tail: List<A>) : List<A>()
object Nil : List<Nothing>()


sealed class List<out A> {

    companion object {

        fun <A> empty(): List<A> = Nil

        fun <A> of(vararg aa: A): List<A> {
            val tail = aa.sliceArray(1 until aa.size)

            return if (aa.isEmpty()) {
                Nil
            } else {
                Cons(aa[0], of(*tail))
            }
        }

        fun sum(xs: List<Int>): Int =
            when (xs) {
                is Nil -> 0
                is Cons -> xs.head + sum(xs.tail)
            }

        fun product(xs: List<Double>): Double =
            when (xs) {
                is Nil -> 1.0
                is Cons -> xs.head * product(xs.tail)
            }

        fun sum2(intList: List<Int>): Int =
            foldRight(intList, 0) { a, b -> a + b }

        fun product2(doubleList: List<Double>): Double =
            foldRight(doubleList, 1.0) { a, b -> a * b }
    }
}

// some convenience functions as extensions ex.3.1
fun <A> List<A>.tail(): List<A> =
    when (this) {
        is Cons -> this.tail
        is Nil -> throw IllegalStateException("Nil can't have a tail")
    }

// replace first (head) element ex.3.2
fun <A> List<A>.setHead(x: A): List<A> =
    when (this) {
        is Cons -> Cons(x, this.tail)
        is Nil -> throw IllegalStateException("Cannot replace Head of a Nil list!")
    }

// ex 3.3
tailrec fun <A> List<A>.drop(n: Int): List<A> =
    if (n == 0) {
        this
    } else when (this) {
        is Cons -> this.tail.drop(n - 1)
        is Nil -> throw IllegalStateException("Can't drop from a NIL list")
    }

tailrec fun <A> dropWhile(l: List<A>, f: (A) -> Boolean): List<A> =
    when (l) {
        is Cons -> if (f(l.head)) dropWhile(l.tail, f) else l
        is Nil -> l
    }


// Using foldRight als generalization of sum and pom
fun <A, B> foldRight(xs: List<A>, z: B, f: (A, B) -> B): B =
    when (xs) {
        is Nil -> z
        is Cons -> f(xs.head, foldRight(xs.tail, z, f))
    }

// ex. 3.9 foldRight is not tail-recursive -> foldLeft is
tailrec fun <A, B> foldLeft(xs: List<A>, z: B, f: (B, A) -> B): B =
    when (xs) {
        is Nil -> z
        is Cons -> foldLeft(xs.tail, f(z, xs.head), f)
    }

// ex.3.8 calc length using foldRight
fun <A> length(xs: List<A>): Int =
    foldRight(xs, 0) { _, acc -> 1 + acc }

fun main() {
    // simple single linked list from varargs
    val intList = List.of(1, 2, 3, 4, 5)
    val doubleList = List.of(1.0, 2.5, 3.1, 4.4, 5.6)
    println(intList)
    println(List.sum(intList))
    println(List.product(doubleList))

    println("Extension tail before: $intList and after tail function\n: ${intList.tail()}")
    println("Extension set Head before: $intList and after setHead function\n: ${intList.setHead(666)}")

    println("Extension to drop elements: before = $intList and after drop first 2 elements: ${intList.drop(2)}")

    val predicate = { i: Int -> i != 4 }
    val result = dropWhile(intList, predicate)
    println("Function to drop elements which match predicate: $result")

    println("\nex 3.8 : Length of intList: ${length(intList)}")

}