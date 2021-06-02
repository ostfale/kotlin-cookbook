package de.ostfale.kotlin.generics.reified

import kotlin.reflect.KClass

open class Fruit
class Apple(private val weight: Int) : Fruit() {
    override fun toString(): String {
        return "Apple(weight=$weight)"
    }
}

class Banana(val length: Int) : Fruit() {
    override fun toString(): String {
        return "Banana(length=$length)"
    }
}

val fruits = listOf(Apple(230), Apple(175), Banana(17), Banana(18), Apple(200))

fun main() {
    println("Traditional style: ${getAllOfType(fruits, Apple::class)}")
    println("Functional style: ${getAllOfTypeFunctional(fruits, Apple::class)}")
    println("Extension style: ${fruits.getAllOfType(Banana::class)}")
    println("Reified style: ${fruits.getAllOfType<Banana>()}")
    println("Kotlin standard lib style: ${fruits.getAllOfTypeFinal<Banana>()}")
}

// separate list with one type (T) using KClass for help
fun <T : Any> getAllOfType(aList: List<*>, myType: KClass<T>): List<T> {
    val result = mutableListOf<T>()
    for (itm in aList) {
        if (itm != null && itm::class == myType)
            result += itm as T
    }
    return result
}

// solution 2 with functional style
fun <T : Any> getAllOfTypeFunctional(aList: List<*>, myType: KClass<T>): List<T> {
    return aList.filterNotNull()
        .filter { it::class == myType }
        .map { it as T }
}

// solution 3 as extension for Iterable
fun <T : Any> Iterable<*>.getAllOfType(myType: KClass<T>): List<T> {
    return this.filterNotNull()
        .filter { it::class == myType }
        .map { it as T }
}

// solution with inline and reified
inline fun <reified T> Iterable<*>.getAllOfType(): List<T> {
    return this.filter { it is T }.map { it as T }
}

// final and simplified solution
inline fun <reified T> Iterable<*>.getAllOfTypeFinal(): List<T> {
    return this.filterIsInstance<T>().map { it }
}