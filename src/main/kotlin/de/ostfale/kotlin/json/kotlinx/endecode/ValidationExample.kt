package de.ostfale.kotlin.json.kotlinx.endecode

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.Serializable
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

/**
 * Another case where you might want to introduce a primary constructor parameter without a property is when you want
 * to validate its value before storing it to a property. To make it serializable you shall replace it with a property
 * in the primary constructor, and move the validation to an init { ... } block.
 */
@Serializable
class ProjectValidation(val name: String) {
    init {
        require(name.isNotEmpty()) { "name must not be empty" }
    }
}

/**
 * A deserialization process works like a regular constructor in Kotlin and calls all init blocks, ensuring that you
 * cannot get an invalid class as a result of deserialization.
 */
@OptIn(ExperimentalSerializationApi::class)
fun main() {
    val data = Json.decodeFromString<ProjectValidation>(
        """
        {"name":""}
    """
    )
    println(data)
}