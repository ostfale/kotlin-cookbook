package de.ostfale.kotlin.serde

import kotlinx.serialization.Serializable
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

// https://kotlin.christmas/2020/9

@Serializable
data class MyFavoriteObject(val favouriteObject: String)

fun main() {
    val fav = MyFavoriteObject("XPS 13 Notebook")
    val jsonString = Json.encodeToString(fav)
    val clazz = Json.decodeFromString<MyFavoriteObject>(jsonString)

    println("Encoded as JSON: $jsonString")
    println("Decoded from JSON to Object: $clazz")
}

