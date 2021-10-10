package de.ostfale.kotlin.json.kotlinx.builtin

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.Serializable
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

// https://github.com/Kotlin/kotlinx.serialization/blob/master/docs/builtin-classes.md#deserializing-collections

@Serializable
data class Data(
    val a: List<Int>,
    val b: Set<Int>
)

@OptIn(ExperimentalSerializationApi::class)
fun main() {
    val data = Json.decodeFromString<Data>(
        """
        {
            "a": [42, 42],
            "b": [42, 42]
        }
    """
    )
    println("Deserializing a list and a set: $data")
}