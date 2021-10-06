package de.ostfale.kotlin.json.kotlinx.basic

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

@Serializable
class ProjectSerial(val name: String, @SerialName("lang") val language: String)

@OptIn(ExperimentalSerializationApi::class)
fun main() {
    val data = ProjectSerial("kotlinx.serialization", "Kotlin")
    println(Json.encodeToString(data))
}