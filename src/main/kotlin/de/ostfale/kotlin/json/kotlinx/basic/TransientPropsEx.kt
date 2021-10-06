package de.ostfale.kotlin.json.kotlinx.basic

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

// https://github.com/Kotlin/kotlinx.serialization/blob/master/docs/basic-serialization.md#optional-property-initializer-call

/**
 * A property can be excluded from serialization by marking it with the @Transient annotation (don't confuse it with
 * kotlin.jvm.Transient). Transient properties must have a default value.
 */
@Serializable
data class TransientPropsEx(val name: String, @Transient val language: String = "Kotlin")

@OptIn(ExperimentalSerializationApi::class)
fun main() {
    val data = Json.decodeFromString<TransientPropsEx>(
        """
        {"name":"kotlinx.serialization","language":"Kotlin"}
    """
    )
    println(data)
}