package de.ostfale.kotlin.json.kotlinx.endecode

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.Serializable
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

/**
 * An object can be deserialized only when all its properties are present in the input.
 */
@Serializable
data class ProjectAllArgsException(val name: String, val language: String)

@Serializable
data class ProjectAllArgsFixed(val name: String, val language: String = "Kotlin")


@OptIn(ExperimentalSerializationApi::class)
fun main() {
    val dataWorking = Json.decodeFromString<ProjectAllArgsFixed>(
        """
        {"name":"kotlinx.serialization"}
    """
    )
    println(dataWorking)

    try {
        val dataException = Json.decodeFromString<ProjectAllArgsException>(
            """
        {"name":"kotlinx.serialization"}
    """
        )
        println(dataException)

    } catch (e: Exception) {
        println("EXCEPTION: ${e.message}")
    }
}