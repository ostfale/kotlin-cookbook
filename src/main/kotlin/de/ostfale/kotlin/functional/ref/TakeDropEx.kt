package de.ostfale.kotlin.functional.ref

fun main() {
    takeDropEx()
    takeDropWhileEx()
}

fun takeDropWhileEx() {
    val lst = listOf(2, 7, 9, 13, 4, 19, 8)
    val noElemsUntillt10 = lst.takeWhile { it < 10 } // [2,7,9]
    val noElementsUntillt10 = lst.dropWhile { it < 10 } // [2,7,9]

    println("Original list: $lst")
    println("All Elements until< 10 : $noElemsUntillt10")
    println("No Elements until < 10  : $noElementsUntillt10")
}

fun takeDropEx() {
    val lst = List(20) { it } // [0,1,..19]
    val first5 = lst.take(5)
    val lastAfterThirdElement = lst.drop(3)
    val last5Elements = lst.takeLast(5)
    val withoutLast5Elements = lst.dropLast(5)

    println("Original list: $lst")
    println("First 5 elements list: $first5")
    println("Last elements after 3 one: $lastAfterThirdElement")
    println("Last 5 elements list: $last5Elements")
    println("Without last 5 elements: $withoutLast5Elements")
}
