package de.ostfale.kotlin.functional.sealed

/**
 *  Creating a sealed class is as easy as adding the sealed modifier to the class. All derived classes of the sealed
 *  class must be nested (Kotlin 1.1) or on the same file (beyond Kotlin 1.1)
 * <br>
 * <ul>
 *    <li>https://medium.com/tompee/idiomatic-kotlin-sealed-classes-bf1772d9d607</li>
 *    <li>https://www.lordcodes.com/articles/the-power-of-sealed-classes-in-kotlin</li>
 *    <li>https://medium.com/kayvan-kaseb/kotlin-sealed-classes-94b93e18108a</li>
 * </ul>
 */

sealed class Attribute

object Intelligence : Attribute()
object Agility : Attribute()
object Strength : Attribute()

// There is no need to add the default clause since the compiler can already figure out that all subclasses of the sealed class has been checked.
fun getAttributeString(attribute: Attribute): String {
    return when (attribute) {
        is Intelligence -> "Intelligence"
        is Strength -> "Strength"
        is Agility -> "Agility"
    }
}

fun main() {
    println(getAttributeString(Agility))
}


sealed class Outcome<out T : Any> {
    data class Success<out T : Any>(val data: T) : Outcome<T>()
    data class Error(val exception: Exception) : Outcome<Nothing>()
}