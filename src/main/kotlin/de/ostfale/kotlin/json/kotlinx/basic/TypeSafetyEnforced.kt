package de.ostfale.kotlin.json.kotlinx.basic

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.Serializable
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

// https://github.com/Kotlin/kotlinx.serialization/blob/master/docs/basic-serialization.md#optional-property-initializer-call

/**
 * Kotlin Serialization strongly enforces the type safety of the Kotlin programming language. Even though the language
 * property has a default value, it is still an error to attempt to assign the null value to it.
 */
@Serializable
data class TypeSafetyEnforced(val name: String, val language: String = "Kotlin")

@OptIn(ExperimentalSerializationApi::class)
fun main() {
    val data = Json.decodeFromString<TypeSafetyEnforced>(
        """
        {"name":"kotlinx.serialization","language":null}
    """
    )
    println(data)
}