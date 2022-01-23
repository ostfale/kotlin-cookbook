
val <T> List<T>.tail: List<T>
    get() = drop(1)

val <T> List<T>.head: T
    get() = first()

val order = { a: Int, b: Int ->
    when {
        a < b -> true
        else -> false
    }
}

val sorter = { a: Int, b: Int ->
    when {
        a > b -> 1
        a < b -> -1
        else -> 0
    }
}

fun <A> isSorted(aa: List<A>, order: (A, A) -> Boolean): Boolean {
    tailrec fun go(x: A, xs: List<A>): Boolean =
        if (xs.isEmpty()) true
        else if (!order(x, xs.head)) false
        else go(xs.head, xs.tail)

    return aa.isEmpty() || go(aa.head, aa.tail)
}

fun main() {
    val listRight: List<Int> = listOf(1, 2, 3, 4, 5, 6)
    val listWrong: List<Int> = listOf(3, 2, 1)

    println("List before tail: $listRight and after: ${listRight.tail}")
    println("List before head: $listRight and head element: ${listRight.head}")
    val rightSorted = isSorted(listRight, order)
    val wrongSorted = isSorted(listWrong, order)
    println("Is list sorted correctly: $rightSorted")
    println("Is list sorted correctly: $wrongSorted")
}