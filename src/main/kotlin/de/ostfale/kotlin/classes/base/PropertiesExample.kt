package de.ostfale.kotlin.classes.base

import org.slf4j.LoggerFactory

class PropertiesExample(private val firstName: String, private var isAlive: Boolean, fullTime: Boolean = true) {

    private val log = LoggerFactory.getLogger(javaClass)

    // backing field generated
    var fullTime = fullTime
        get() {
            log.info("get message from field...")
            return field
        }
        set(value) {
            log.info("set msg from field")
            field = value
        }

    fun printProp() {
        log.info("Name is $firstName and isAlive: $isAlive and is fulltime employed: $fullTime")
    }
}

fun main() {
    val myPropertiesExample = PropertiesExample("Iwan", false)
    myPropertiesExample.printProp()
}
