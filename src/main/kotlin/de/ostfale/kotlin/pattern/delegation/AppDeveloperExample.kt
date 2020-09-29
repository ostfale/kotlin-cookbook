package de.ostfale.kotlin.pattern.delegation

import org.slf4j.LoggerFactory

// https://proandroiddev.com/dont-reinvent-the-wheel-delegate-it-eac132f2aa64

interface AppDeveloper {
    fun prepareEnvironments()
    fun buildApp()
}

class MobileDeveloper(val name: String) : AppDeveloper {

    private val log = LoggerFactory.getLogger(javaClass)

    override fun prepareEnvironments() {
        log.info("$name is preparing the environment...")
    }

    override fun buildApp() {
        log.info("$name is doing the hard work...")
    }
}

class IdeasMachine(val name: String) {
    fun giveIdeaTo(developer: AppDeveloper) {
        developer.prepareEnvironments()
        developer.buildApp()
    }
}

class Company(developer: AppDeveloper) : AppDeveloper by developer

fun main() {
    val charlie = MobileDeveloper("Charlie")
    val bob = IdeasMachine("Bob")
    val alice = Company(charlie)
    bob.giveIdeaTo(alice)
}