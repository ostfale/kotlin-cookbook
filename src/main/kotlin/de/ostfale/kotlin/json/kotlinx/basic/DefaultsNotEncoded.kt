package de.ostfale.kotlin.json.kotlinx.basic

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

// https://github.com/Kotlin/kotlinx.serialization/blob/master/docs/basic-serialization.md#optional-property-initializer-call

/**
 * Default values are not encoded by default in JSON. This behavior is motivated by the fact that in most real-life
 * scenarios such configuration reduces visual clutter, and saves the amount of data being serialized.
 */
@Serializable
data class DefaultsNotEncoded(val name: String, val language: String = "Kotlin")

@OptIn(ExperimentalSerializationApi::class)
fun main() {
    val data = DefaultsNotEncoded("kotlinx.serialization")
    println(Json.encodeToString(data))
}