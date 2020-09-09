package de.ostfale.kotlin.classes.inheritence

/**
 * Example for a subclass (use a colon to define a subclass). Use the keyword override to update
 * properties and functions
 * Created :  16.07.2019
 *
 *  @author : Uwe Sauerbrei
 */
class Hippo : Animal() {

    override val image = "hippo.jpg"
    override val food = "grass"
    override val habitat = "water"

    override fun makeNoise() {
        println("Grunt Grunt...")
    }

    override fun eat() {
        println("The Hippo is eating $food")
    }
}