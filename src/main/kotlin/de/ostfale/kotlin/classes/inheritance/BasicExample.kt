package de.ostfale.kotlin.classes.inheritance

open class Bicycle(private val gears: Int, val weight: Double) {
    var gear: Int = 1

    fun changeGear(gear: Int) {
        if (gear in 1..gears) {
            this.gear = gear
        }
    }
}

class MountainBike(gears: Int, weight: Double, val suspension: Double) : Bicycle(gears, weight) {
    var lockout = true
    fun lockSuspension() = run { lockout = true }
    fun unlockSuspension() = run { lockout = false }
}