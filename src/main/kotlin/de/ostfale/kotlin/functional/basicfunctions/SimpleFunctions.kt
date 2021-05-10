package de.ostfale.kotlin.functional.basicfunctions

fun main() {
    println("Password: " + makePassword(8))
    println("Password: " + makePassword(8, 2))

    val (mi, ma) = getMinMaxWithPair(arrayOf(1, 4, -3, 12))
    println("Min val: $mi and max val: $ma")
}

fun getMinMaxWithPair(data: Array<Int>): Pair<Int, Int> {
    var min = data[0]
    var max = data[0]
    for (itm in data) {
        if (itm < min) min = itm
        if (itm > max) max = itm
    }
    return Pair(min, max)
}

fun makePassword(len: Int, nonLetter: Int = 0): String {
    val lower = "abcdefghijklmnopqrstuvwxyz"
    val letter = lower + lower.uppercase()
    val other = "1234567890,.-;:_!#+*%&/="
    val lst = mutableListOf<Char>()
    for (i in 0 until nonLetter) lst += other.random()
    for (i in 0 until len - nonLetter) lst += letter.random()

    return lst.shuffled().joinToString(separator = "")
}
