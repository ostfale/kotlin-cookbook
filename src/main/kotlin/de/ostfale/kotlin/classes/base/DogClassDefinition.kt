package de.ostfale.kotlin.classes.base

import org.slf4j.LoggerFactory


class Dog(private val name: String, private var weight: Int, private val breed: String) {

    private val log = LoggerFactory.getLogger(javaClass)

    fun bark() {
        log.info(if (weight < 20) "Yip -> $name ($breed)" else "Woof! -> $name ($breed)")
    }
}

// Example class with a secondary constructor
class Mushroom(val size: Int, val isMagic: Boolean) {
    constructor(isMagic_param: Boolean) : this(0, isMagic_param)
}


/**
 * Example class with constructor which allows to set defaults or validate parameter or initialize parameter
 * without constructor
 */
class DogWithoutType(name_param: String, weight_param: String, breed_param: String) {
    val name = name_param
    var weight = weight_param
    val breed = breed_param.toUpperCase()
    var activities = arrayOf("Walks")
}


fun main() {
    val myDog = Dog("Fido", 70, "mixed")
    val dogs = arrayOf(myDog, Dog("Ripper", 10, "Poodle"))
    for (dog in dogs) {
        dog.bark()
    }
}