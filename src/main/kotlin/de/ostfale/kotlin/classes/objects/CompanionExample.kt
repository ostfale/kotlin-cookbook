package de.ostfale.kotlin.classes.objects

/**
 * Another example for the use of the object keyword : Companion Objects. Because there is no static keyword in Kotlin
 * Could be used to create a factory pattern as the example below shows.
 * we can't access a function without creating an object instance.
 * Created :  26.08.2019
 *
 *  @author : Uwe Sauerbrei
 */
class SomeClass private constructor(val someString: String) {

    companion object {
        private var privateVar = 6

        fun accessingPrivateVar() = "I'm accessing a private var: $privateVar"

        fun justAssign(str: String) = SomeClass(str)
        fun upperOrLowerCase(str: String, lowerCase: Boolean): SomeClass {
            return if (lowerCase) {
                SomeClass(str.lowercase())
            } else {
                SomeClass(str.uppercase())
            }
        }
    }
}

fun main() {
    // access function without instantiating an instance of the class
    println(SomeClass.accessingPrivateVar())

    val someClass1 = SomeClass.justAssign("this is the string as is")
    val someClass2 = SomeClass.upperOrLowerCase("this is the string as is", false)
    println(someClass1.someString)
    println(someClass2.someString)
}