package de.ostfale.kotlin.functional.basicfunctions

class FunctionWithVarargsEx {

    private val myArray = arrayOf(4, 5, 6, 7, 8)

    private fun <T> valuesToList(vararg values: T): MutableList<T> {
        val list: MutableList<T> = mutableListOf()
        for (i in values) {
            list.add(i)
        }
        return list
    }

    fun listExample() {
        val mList = valuesToList(1, 2, 3, 4, 5, 6)
        println("Show list members: $mList")
    }

    fun arrayExample() {
        val mList = valuesToList(0, *myArray, 2)
        println("Show spread array example: $mList")
    }
}

fun main() {
    val myFunctionWithVarargs = FunctionWithVarargsEx()
    myFunctionWithVarargs.listExample()
    myFunctionWithVarargs.arrayExample()
}