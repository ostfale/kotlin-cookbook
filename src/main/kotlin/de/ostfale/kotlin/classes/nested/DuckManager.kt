package de.ostfale.kotlin.classes.nested

object DuckManager {

    val newDuck = Duck.create()
    val x = Duck.Companion
    val allDucks = mutableListOf<Duck>()
    fun herdDucks() {

    }
}

fun main() {
    DuckManager.herdDucks()
}

class Duck {
   // object DuckFactory {
    companion object {
        fun create(): Duck = Duck()
    }
}