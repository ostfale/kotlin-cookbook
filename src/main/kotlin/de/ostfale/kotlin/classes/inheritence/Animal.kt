package de.ostfale.kotlin.classes.inheritence

import de.ostfale.kotlin.classes.inheritence.interfaces.Roamable

abstract class Animal : Roamable {

    abstract val image: String
    abstract val food: String
    abstract val habitat: String
    var hunger = 10

    abstract fun makeNoise()
    abstract fun eat()

    override fun roam() {
        println("The animal is roaming...")
    }

    fun sleep() {
        println("The animal is sleeping...")
    }
}