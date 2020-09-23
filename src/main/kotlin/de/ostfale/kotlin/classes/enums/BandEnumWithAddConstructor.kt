package de.ostfale.kotlin.classes.enums

import org.slf4j.LoggerFactory

/**
 * Example for an enum class with constructor for additional attributes
 */
enum class BandEnumWithAddConstructor(val instrument: String) {

    JERRY("lead guitar") {
        override fun sings() = "plaintively"
    },
    BOBBY("rhythm guitar") {
        override fun sings() = "hoarsely"
    },
    PHIL("bass");

    open fun sings() = "occasionally"
}

fun main() {
    val log = LoggerFactory.getLogger(BandEnumWithAddConstructor::class.java)

    val bobby: BandEnumWithAddConstructor = BandEnumWithAddConstructor.BOBBY
    log.info("Selected band members (${bobby.name}) instrument: ${bobby.instrument}")
    log.info("Selected band member sings ${bobby.sings()}")

    val jerry: BandEnumWithAddConstructor = BandEnumWithAddConstructor.JERRY
    log.info("Selected band members (${jerry.name}) instrument: ${jerry.instrument}")
    log.info("Selected band member sings ${jerry.sings()}")

    val phil: BandEnumWithAddConstructor = BandEnumWithAddConstructor.PHIL
    log.info("Selected band members (${phil.name}) instrument: ${phil.instrument}")
    log.info("Selected band member sings ${phil.sings()}")
}