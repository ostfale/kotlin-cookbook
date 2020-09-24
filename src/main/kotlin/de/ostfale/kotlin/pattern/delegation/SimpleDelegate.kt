package de.ostfale.kotlin.pattern.delegation

// https://medium.com/yellowme/delegation-pattern-in-kotlin-a0ce5c5bb89f

interface Base {
    fun print()
}

class BaseImpl(val x: Int) : Base {

    override fun print() {
        println(x)
    }
}

/**
 * A class implements an interface by delegating its members to a specific object that conforms to it, instead
 * of inheriting them from a class directly.
 * The by keyword indicates that the class implements the interface by an object it contains, an object of which
 * details we don't need to know (since it's an interface).
 */
class Derived(b: Base) : Base by b

fun main() {
    val b = BaseImpl(10)
    Derived(b).print()
}