package de.ostfale.kotlin.classes.base

import org.slf4j.LoggerFactory

class DogClassWithSetter(val name: String, weight_param: Int, breed_param: String) {

    private val log = LoggerFactory.getLogger(javaClass)

    var activities = arrayOf("Walk")
    val breed = breed_param.uppercase()

    // explicit use of a setter
    var weight = weight_param
        set(value) {
            if (value > 0) field = value
        }

    fun printIt(message: String) {
        log.info(message)
    }
}

fun main() {
    val myDog = DogClassWithSetter("Fiso", 22, "pinscher")
    myDog.weight = -22
    myDog.printIt("Dog is ${myDog.name} with weight ${myDog.weight} and breed : ${myDog.breed}")
}