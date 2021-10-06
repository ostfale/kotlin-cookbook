package de.ostfale.kotlin.json.kotlinx.endecode

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

// https://github.com/Kotlin/kotlinx.serialization/blob/master/docs/basic-serialization.md

@Serializable
class ProjectConstructor private constructor(private val owner: String, val name: String) {
    constructor(path: String) : this(
        owner = path.substringBefore("/"),
        name = path.substringAfter("/")
    )

    val path: String
        get() = "$owner/$name"
}

@OptIn(ExperimentalSerializationApi::class)
fun main() {
    println(Json.encodeToString(ProjectConstructor("kotlin/kotlinx.serialization")))
}