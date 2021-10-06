package de.ostfale.kotlin.json.kotlinx.basic

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

// https://github.com/Kotlin/kotlinx.serialization/blob/master/docs/basic-serialization.md#optional-property-initializer-call

/**
 * Nullable properties are natively supported by Kotlin Serialization. This example does not encode null in JSON
 * because Defaults are not encoded.
 */
@Serializable
class NullableProps(val name: String, val renamedTo: String? = null)

@OptIn(ExperimentalSerializationApi::class)
fun main() {
    val data = NullableProps("kotlinx.serialization")
    println(Json.encodeToString(data))
}