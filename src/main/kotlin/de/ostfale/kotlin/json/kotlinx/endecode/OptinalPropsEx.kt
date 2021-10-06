package de.ostfale.kotlin.json.kotlinx.endecode

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.Serializable
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

// https://github.com/Kotlin/kotlinx.serialization/blob/master/docs/basic-serialization.md#optional-property-initializer-call

fun computeLanguage(): String {
    println("Computing")
    return "Kotlinx"
}

/**
 * When an optional property is present in the input, the corresponding initializer for this property is not even
 * called. This is a feature designed for performance, so be careful not to rely on side effects in initializers.
 */
@Serializable
data class OptionalPropsEx(val name: String, val language: String = computeLanguage())

@OptIn(ExperimentalSerializationApi::class)
fun main() {
    val data = Json.decodeFromString<OptionalPropsEx>("""
        {"name":"kotlinx.serialization","language":"Kotlin"}
    """)
    println(data)
}

