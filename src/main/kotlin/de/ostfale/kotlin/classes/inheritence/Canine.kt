package de.ostfale.kotlin.classes.inheritence

abstract class Canine : Animal() {

    override fun roam() {
        println("The Canine is roaming...")
    }
}