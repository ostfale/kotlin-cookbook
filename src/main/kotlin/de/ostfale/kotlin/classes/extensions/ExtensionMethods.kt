package de.ostfale.kotlin.classes.extensions

fun String.left(n: Int) =
    if (n >= this.length) this
    else this.substring(0, n)

fun String.right(n: Int) =
    if (n >= this.length) this
    else this.substring(this.length - n)

fun main() {
    val source = "abcdefg"
    println("Left 2 character: ${source.left(2)}")
    println("Right last character: ${source.right(1)}")
}