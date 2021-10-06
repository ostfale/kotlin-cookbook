package de.ostfale.kotlin.json.kotlinx.basic

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.Serializable
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

@Serializable
class Project(var name: String, private val language: String) {

    var stars: Int = 1                  // property with backing field is -- serialized
    private val path: String            // getter only, no backing field -- not serialized
        get() = "kotlin/$name"
    var id by ::name                    // delegated property - not serialized

    override fun toString(): String {
        return """
            Name:       $name
            Language:   $language
            Stars:      $stars
            Path:       $path
            id:         $id
        """
    }
}

@OptIn(ExperimentalSerializationApi::class)
fun main() {
    val data = Project("kotlinx.serialization", "Kotlin").apply { stars = 9000 }
    val json = Json.encodeToString(data)
    println("Encoded to String: $json")

    val reverse = Json.decodeFromString<Project>(json)
    println("\nDecoded: $reverse")
}