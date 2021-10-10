package de.ostfale.kotlin.json.kotlinx.builtin

import kotlinx.serialization.*
import kotlinx.serialization.json.*

// https://github.com/Kotlin/kotlinx.serialization/blob/master/docs/builtin-classes.md#unit-and-singleton-objects

/**
 * The Kotlin builtin Unit type is also serializable. Unit is a Kotlin singleton object, and is handled equally with
 * other Kotlin objects. Conceptually, a singleton is a class with only one instance, meaning that state does not
 * define the object, but the object defines its state. In JSON, objects are serialized as empty structures.
 */
@Serializable
object SerializationVersion {
    val libraryVersion: String = "1.0.0"
}

@OptIn(ExperimentalSerializationApi::class)
fun main() {
    println(Json.encodeToString(SerializationVersion))
    println(Json.encodeToString(Unit))
}