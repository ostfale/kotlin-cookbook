package de.ostfale.kotlin.classes.interfaces

// normal interface
interface Action1 {
    fun run()
}

// SAM interface using 'fun'
fun interface Action2 {
    fun run()
}

fun runAction1(a: Action1) = a.run()
fun runAction2(a: Action2) = a.run()
fun runAction3(a: () -> Unit) = a()

fun main() {
    runAction1(object : Action1 {
        override fun run() {
            println("This is no SAM!")
        }
    })
    runAction2 { println("This is a SAM interface!") }
    runAction3 { println("Function as parameter!") }
}