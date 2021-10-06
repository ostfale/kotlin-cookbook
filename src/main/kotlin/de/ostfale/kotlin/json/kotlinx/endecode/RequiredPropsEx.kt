package de.ostfale.kotlin.json.kotlinx.endecode

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.Required
import kotlinx.serialization.Serializable
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

// https://github.com/Kotlin/kotlinx.serialization/blob/master/docs/basic-serialization.md#optional-property-initializer-call

/**
 * A property with a default value can be required in a serial format with the @Required annotation.
 */
@Serializable
data class RequiredPropsEx(val name: String, @Required val language: String = "Kotlin")

@OptIn(ExperimentalSerializationApi::class)
fun main() {
    val data = Json.decodeFromString<RequiredPropsEx>(
        """
        {"name":"kotlinx.serialization"}
    """
    )
    println(data)
}