package de.ostfale.kotlin.classes.inheritence

class Wolf : Canine() {

    override val image = "wolf.jpg"
    override val food = "meat"
    override val habitat = "forests"

    override fun makeNoise() {
        println("Hooooowl!!")
    }

    override fun eat() {
        println("The wolf is eating $food")
    }

    fun getAlphaWolf(): Wolf {
        return Wolf()
    }
}