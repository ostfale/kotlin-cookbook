package de.ostfale.kotlin.pattern.structural.composition

import de.ostfale.kotlin.pattern.structural.bridge.RegularLegs
import de.ostfale.kotlin.pattern.structural.bridge.Rifle
import de.ostfale.kotlin.pattern.structural.bridge.StormTrooper
import de.ostfale.kotlin.pattern.structural.bridge.Trooper

class Squad(private val units: List<Trooper>) : Trooper {
    // allows to add single Troopers not a list
    constructor(vararg units: Trooper) : this(units.toList())

    override fun move(x: Long, y: Long) {
        for (u in units) {
            u.move(x, y)
        }
    }

    override fun attackRebel(x: Long, y: Long) {
        for (u in units) {
            u.attackRebel(x, y)
        }
    }
}

fun main() {
    val bobaFett = StormTrooper(Rifle(), RegularLegs())
    val squad = Squad(listOf(bobaFett.copy(), bobaFett.copy(), bobaFett.copy()))
    squad.attackRebel(1, 2)

    val secondSquad = Squad(
        bobaFett.copy(),
        bobaFett.copy(),
        bobaFett.copy()
    )
    secondSquad.move(2,4)
}
