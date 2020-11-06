package de.ostfale.kotlin.functional.extensions

import org.slf4j.LoggerFactory

/**
 * Links: <br>
 *  <ul>
 *   <li>https://medium.com/tompee/idiomatic-kotlin-extension-functions-67735491851f</li>
 *  </ul>>
 */

fun main() {
    Extensions().testSecond()
}

class Extensions {

    private val log = LoggerFactory.getLogger(javaClass)

    fun testSecond() {
        log.info("Show second char of a String 'Test': {}", "Test".second())
        log.info("Show second char of a String 'A': {}", "A".second())
    }
}

fun String.second(): Char {
    if (length == 0) throw NoSuchElementException("Char sequence is empty.")
    if (length < 2) throw NoSuchElementException("Char sequence length is less than 2.")
    return this[1]
}