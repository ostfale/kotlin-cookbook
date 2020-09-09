package de.ostfale.kotlin.classes.inheritence.interfaces

interface Roamable {

    var velocity: Int
        get() = 20
        set(value) {
            println("Unable to update velocity to $value !!")
        }

    fun roam()
}