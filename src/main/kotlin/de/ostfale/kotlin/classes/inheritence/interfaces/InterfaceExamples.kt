package de.ostfale.kotlin.classes.inheritence.interfaces

interface MyInterface {
    val number: Int
    val number2: Int
        get() = number * 10

    fun myFunction(str: String): String
}

interface MySubInterface : MyInterface {

    fun mySubFunction(num: Int): String
}

open class Something : MySubInterface {

    val someProperty: String
    override val number: Int = 25

    constructor(someParameter: String) {
        someProperty = someParameter
    }

    override fun myFunction(str: String): String {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun mySubFunction(num: Int): String {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}