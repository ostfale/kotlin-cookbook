package de.ostfale.kotlin.json.kotlinx.builtin

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

// https://github.com/Kotlin/kotlinx.serialization/blob/master/docs/builtin-classes.md

/**
 * The simple data classes Pair and Triple from the Kotlin standard library are serializable.
 */
@Serializable
class ProjectPair(val name: String)

@OptIn(ExperimentalSerializationApi::class)
fun main() {
    val pair = 1 to ProjectPair("kotlinx.serialization")
    println(Json.encodeToString(pair))
}