package de.ostfale.kotlin.functional.lambda

import org.slf4j.LoggerFactory

/**
 * You can use a lambda as part of an extension function
 * Created :  24.08.2020
 *
 *  @author : Uwe Sauerbrei
 */

class LambdaExtension

private val log = LoggerFactory.getLogger(LambdaExtension::class.java)

fun String.validateString(size: Int): String {
    val result = if (this.length > size) this else "Invalid String"
    log.info("Validate length of string usual way: {}", result)
    return result
}

val greaterThanString: String.(Int) -> String = {
    val result = if (this.length > it) this else "Invalid String"
    log.info("Validate length of string with lambda: {}", result)
    result
}

fun main() {
    "This is a valid string".validateString(5)
    "This is a valid string".greaterThanString(5)
}