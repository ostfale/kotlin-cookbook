package de.ostfale.kotlin.json.kotlinx.builtin

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

// https://github.com/Kotlin/kotlinx.serialization/blob/master/docs/builtin-classes.md#maps

/**
 * Kotlin maps in JSON are represented as objects. In JSON object keys are always strings, so keys are encoded as
 * strings even if they are numbers in Kotlin, as we can see below.
 */
@Serializable
class ProjectMap(val name: String)

@OptIn(ExperimentalSerializationApi::class)
fun main() {
    val map = mapOf(
        1 to ProjectMap("kotlinx.serialization"),
        2 to ProjectMap("kotlinx.coroutines")
    )
    println("Serialize a map: ${Json.encodeToString(map)}")
}