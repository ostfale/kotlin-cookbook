package de.ostfale.kotlin.classes.base

import org.slf4j.LoggerFactory

class DogClassWithGetter(val name: String, var weight: Int, breed_param: String) {

    private val log = LoggerFactory.getLogger(javaClass)

    var activities = arrayOf("Walks")
    val breed = breed_param.uppercase()

    // value is calculated using a getter function
    val weightInKgs: Double
        get() = weight / 2.2

    fun printIt(message: String) {
        log.info(message)
    }
}

fun main() {
    val myDog = DogClassWithGetter("Frodo", 22, "GG")
    myDog.printIt("Weight in kg: ${myDog.weightInKgs}")
}