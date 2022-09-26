package de.ostfale.kotlin.pattern.behavioral.state

import de.ostfale.kotlin.pattern.behavioral.state.Mood.*

// similar to strategy pattern but not set from outside but internal state changes
sealed class Mood {
    object Still : Mood()
    object Aggressive : Mood()
    object Retreating : Mood()
    object Dead : Mood()
}

interface WhatCanHappen {
    fun seeHero()
    fun getHit(pointsOfDamage: Int)
    fun calmAgain()
}

// snail is the context
class Snail : WhatCanHappen {
    private var mood: Mood = Still
    private var healthPoints = 10

    override fun seeHero() {
        mood = when (mood) {
            is Still -> {
                println("Aggressive")
                Aggressive
            }

            else     -> {
                println("No change")
                mood
            }
        }
    }

    override fun getHit(pointsOfDamage: Int) {
        println("Hit for $pointsOfDamage points")
        healthPoints -= pointsOfDamage

        println("Health: $healthPoints")
        mood = when {
            (healthPoints <= 0) -> {
                println("Dead")
                Dead
            }

            mood is Aggressive  -> {
                println("Retreating")
                Retreating
            }

            else                -> {
                println("No change")
                mood
            }
        }
    }

    override fun calmAgain() {
        println("I'm relaxing now...")
    }
}

fun main() {
    val snail = Snail()
    snail.seeHero()
    snail.getHit(1)
    snail.getHit(10)
}
