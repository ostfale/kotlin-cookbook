package de.ostfale.kotlin.classes.interfaces

interface MyInterface {
    abstract val someProperty: Boolean
    abstract fun someMethod(x: Int, y: String): Double
    fun otherMethod(x: Int, y: Int) = x + y
}

class MyClass : MyInterface {
    override val someProperty: Boolean = false
    override fun someMethod(x: Int, y: String): Double {
        return x + y.length * 0.4
    }
}

class MyClassExtended(private val prop1: Int, private val prop2: Int) : MyInterface {
    override val someProperty: Boolean
        get() = prop1 == prop2

    override fun someMethod(x: Int, y: String): Double {
        return if (someProperty) prop1 * 2.25 else prop1 * 2.1 + prop2 * 4.3
    }

    override fun otherMethod(x: Int, y: Int): Int {
        return prop2 * prop1
    }
}