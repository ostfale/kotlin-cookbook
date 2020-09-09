package de.ostfale.kotlin.classes.inheritence

abstract class Feline : Animal() {

    override fun roam() {
        println("The Feline is miauing...")
    }
}