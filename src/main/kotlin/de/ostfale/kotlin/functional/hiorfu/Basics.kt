package de.ostfale.kotlin.functional.hiorfu

// long version of a function which returns another (anonymous) function
fun generateMultiplyLong(): (Int) -> Int {
    return fun(x: Int): Int {
        return x * 2
    }
}

// shorter version of the function above (lambda function)
fun generateMultiplyShort(): (Int) -> Int {
    return { x: Int -> x * 2 }
}

// function as a parameter as regular argument
fun mathInvoker(x: Int, mathFunction: (Int) -> Int) {
    println(mathFunction(x))
}

// if function is last argument apply outside bracket


fun main() {
    val shortMultiply = generateMultiplyShort()
    println("Result of shortMultiply: " + shortMultiply(4))

    mathInvoker(7, shortMultiply)
    mathInvoker(8) { x -> x * x }
}
