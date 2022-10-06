package de.ostfale.kotlin.pattern.behavioral.command

fun main() {
    val t = Trooper()

    t.addOrder(moveGenerator(t, 1, 1))
    t.addOrder(moveGenerator(t, 2, 2))
    t.addOrder(fightGenerator(t))
    t.addOrder(moveGenerator(t, 3, 3))

    t.executeOrders()
}

open class Trooper {
    private val orders = mutableListOf<Command>()

    fun addOrder(order: Command) {
        this.orders.add(order)
    }

    fun executeOrders() {
        while (orders.isNotEmpty()) {
            val order = orders.removeFirst()
            order() // Compile error for now
        }
    }
    // More code here

    fun move(x: Int, y: Int) {
        println("Moving to $x:$y")
    }

    fun fight() {
        println("Just fighting")
    }
}

// does something = command
typealias Command = () -> Unit

val moveGenerator = fun(
    s: Trooper, x: Int, y: Int
): Command {
    return fun() {
        s.move(x, y)
    }
}

val fightGenerator = fun(s: Trooper): Command {
    return fun() { s.fight() }
}
