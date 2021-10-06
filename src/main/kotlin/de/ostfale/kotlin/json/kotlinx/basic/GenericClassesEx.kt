package de.ostfale.kotlin.json.kotlinx.basic

import kotlinx.serialization.*
import kotlinx.serialization.json.*

// https://github.com/Kotlin/kotlinx.serialization/blob/master/docs/basic-serialization.md#generic-classes

/**
 * Generic classes in Kotlin provide type-polymorphic behavior, which is enforced by Kotlin Serialization at compile-time.
 */
@Serializable
class Box<T>(val content: T)

@Serializable
class Data(
    val a: Box<Int>,
    val b: Box<Project>
)

@OptIn(ExperimentalSerializationApi::class)
fun main() {
    val data = Data(Box(42), Box(Project("kotlinx.serialization", "Kotlin")))
    println(Json.encodeToString(data))
}