package de.ostfale.kotlin.functional.extensions

// https://medium.com/androiddevelopers/extend-your-code-readability-with-kotlin-extensions-542bf702aa36

fun main() {
    val dog = Dog("Hasso", "Collie", 15)
    val nullDog: AnotherDog? = null
    dog.printDogInformation()
    nullDog.printInformation()
    println("Is Dog: ${dog.name} ready for adoption: ${dog.isReadyToAdopt()}")
}

data class Dog(val name: String, val breed: String, val age: Int)
data class AnotherDog(val name: String, val breed: String, val age: Int)

fun Dog.printDogInformation() {
    println("Meet $name, a $age year old $breed")
}


fun Dog.isReadyToAdopt(): Boolean {
    return this.age > 1
}

fun AnotherDog?.printInformation() {
    if (this == null) {
        println("No dog found!")
        return
    }
    println("Meet $name, a $age year old $breed")
}

