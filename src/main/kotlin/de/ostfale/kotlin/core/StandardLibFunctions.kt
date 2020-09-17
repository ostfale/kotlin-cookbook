package de.ostfale.kotlin.core


// inline fun TODO(reason: String = " ... ") : Nothing
class TodoExample{
    fun createAction(id:String) : String = TODO("String result needs to be implemented")
}

// inline fun repeat(times: Int, action: (Int) -> Unit): Unit

// inline fun <T> T.takeIf(predicate: (T) -> Boolean) : T?

// inline fun <T> T.takeUnless(predicate: (T) -> Boolean) : T?

fun main() {
    TodoExample().createAction("id")
}