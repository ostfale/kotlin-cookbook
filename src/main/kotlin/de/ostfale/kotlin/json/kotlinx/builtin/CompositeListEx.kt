package de.ostfale.kotlin.json.kotlinx.builtin

import kotlinx.serialization.*
import kotlinx.serialization.json.*

// https://github.com/Kotlin/kotlinx.serialization/blob/master/docs/builtin-classes.md

/**
 * A List of serializable classes can be serialized.
 */
@Serializable
class ProjectList(val name: String)

@OptIn(ExperimentalSerializationApi::class)
fun main() {
    val list = listOf(
        ProjectList("kotlinx.serialization"),
        ProjectList("kotlinx.coroutines")
    )
    println(Json.encodeToString(list))
}