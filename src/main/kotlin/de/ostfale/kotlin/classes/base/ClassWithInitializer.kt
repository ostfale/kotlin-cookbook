package de.ostfale.kotlin.classes.base

import org.slf4j.LoggerFactory

/**
 * Example for a class with an initializer block. A class can have more than one initializer block. These blocks are called after
 * the constructor has finished.
 */
class DogWithInitializer(private val name: String, var weight: Int, private val breed_param: String) {

    private val log = LoggerFactory.getLogger(javaClass)

    // runs after parameter are initialized
    init {
        log.info("Dog $name has been created...")
    }

    // runs after first initializer block
    var activities = arrayOf("Walks")
    private val breed = breed_param.toUpperCase()

    // runs after properties above have been created
    init {
        log.info("The breed is: $breed")
    }

    // only way not to initialize a property (works only for String)
    lateinit var temperament: String
}

fun main() {
    DogWithInitializer("Lassie", 12, "Collie")
}