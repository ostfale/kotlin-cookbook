package de.ostfale.kotlin.collections.set

fun main() {
    simpleSetCreation()
    buildSetExample()
    lottoExample()
}

fun lottoExample() {
    val lotto = mutableSetOf<Int>()
    do {
        lotto += (1..49).random()
    } while (lotto.size < 6)
    println("Lotto numbers: $lotto")
    val ordered = lotto.toList().sorted()
    println("Lotto numbers sorted: $ordered")
}

@OptIn(ExperimentalStdlibApi::class)
fun buildSetExample() {
    val set = buildSet<Int> {
        repeat(10) { add((1..100).random()) }
    }
    println("Random set: $set")
}

fun simpleSetCreation() {
    val vocals = setOf('a', 'e', 'i', 'o', 'u')
    val result = 'e' in vocals
    println("e in vocals: $result")
}
