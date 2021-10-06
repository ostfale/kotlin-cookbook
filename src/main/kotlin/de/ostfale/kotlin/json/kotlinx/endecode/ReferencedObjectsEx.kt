package de.ostfale.kotlin.json.kotlinx.endecode

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

// https://github.com/Kotlin/kotlinx.serialization/blob/master/docs/basic-serialization.md#optional-property-initializer-call

/**
 * Serializable classes can reference other classes in their serializable properties. The referenced classes must
 * be also marked as @Serializable.
 * References to non-serializable classes can be marked as Transient properties, or a custom serializer can be
 * provided for them
 */
@Serializable
data class ReferencedObjectsEx(val name: String, val owner: User)

@Serializable
data class User(val name: String)

@OptIn(ExperimentalSerializationApi::class)
fun main() {
    val owner = User("kotlin")
    val data = ReferencedObjectsEx("kotlinx.serialization", owner)
    println(Json.encodeToString(data))
}