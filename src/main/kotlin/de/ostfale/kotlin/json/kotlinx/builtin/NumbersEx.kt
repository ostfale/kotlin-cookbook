package de.ostfale.kotlin.json.kotlinx.builtin

import kotlinx.serialization.*
import kotlinx.serialization.json.*
import java.lang.Math.PI

// https://github.com/Kotlin/kotlinx.serialization/blob/master/docs/builtin-classes.md

/**
 * Kotlin Serialization has the following ten primitives: Boolean, Byte, Short, Int, Long, Float, Double, Char,
 * String, and enums. The other types in Kotlin Serialization are composite—composed of those primitive values.
 */
@Serializable
class DataNumbers(
    val answer: Int,
    val pi: Double
)

@OptIn(ExperimentalSerializationApi::class)
fun main() {
    val data = DataNumbers(42, PI)
    println(Json.encodeToString(data))
}