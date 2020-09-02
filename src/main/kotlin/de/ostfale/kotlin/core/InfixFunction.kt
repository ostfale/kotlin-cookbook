package de.ostfale.kotlin.core

/**
 * A function with prefix 'infix' can be called without dot notation
 */
class FunctionWithInfix {

    infix fun bark(x: Int) {
        for (i in 1..x) {
            println("Wuff!")
        }
    }
}

fun main() {
    FunctionWithInfix() bark 6
}