package de.ostfale.kotlin.classes.inheritence

class Lion : Feline() {

    override val image = "lion.jpg"
    override val food = "meat"
    override val habitat = "savannah"

    override fun makeNoise() {
        println("Brüll!!")
    }

    override fun eat() {
        println("The lion is eating $food")
    }
}