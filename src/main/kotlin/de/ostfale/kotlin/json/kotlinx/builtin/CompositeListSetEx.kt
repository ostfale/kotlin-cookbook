package de.ostfale.kotlin.json.kotlinx.builtin

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

// https://github.com/Kotlin/kotlinx.serialization/blob/master/docs/builtin-classes.md

/**
 * A List of serializable classes can be serialized.
 */
@Serializable
class ProjectList(val name: String)

@Serializable
class ProjectSet(val name: String)

@OptIn(ExperimentalSerializationApi::class)
fun main() {
    val list = listOf(
        ProjectList("kotlinx.serialization"),
        ProjectList("kotlinx.coroutines")
    )

    val set = setOf(
        ProjectSet("kotlinx.serialization"),
        ProjectSet("kotlinx.coroutines")
    )
    println("Serialized List: " + Json.encodeToString(list))
    println("Serialized Set: " + Json.encodeToString(set))
}