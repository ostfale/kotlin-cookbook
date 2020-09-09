package de.ostfale.kotlin.classes.inheritence

class Lynx : Feline() {

    override val image = "lynx.jpg"
    override val food = "meat"
    override val habitat = "savannah"

    override fun makeNoise() {
        println("Lynx-Brüll!!")
    }

    override fun eat() {
        println("The lynx is eating $food")
    }
}