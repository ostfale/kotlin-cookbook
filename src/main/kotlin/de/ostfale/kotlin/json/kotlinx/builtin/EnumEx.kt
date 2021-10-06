package de.ostfale.kotlin.json.kotlinx.builtin

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

// https://github.com/Kotlin/kotlinx.serialization/blob/master/docs/builtin-classes.md
// @Serializable annotation is not need for a enum classes
enum class Status {
    SUPPORTED
}

/**
 * Serial names of enum entries can be customized with the SerialName annotation just like it was shown for properties
 * in the Serial field names section. However, in this case, the whole enum class must be marked with the @Serializable
 * annotation.
 */
@Serializable
enum class SerStatus {
    @SerialName("maintained")
    NOT_SUPPORTED
}

/**
 * All enum classes are serializable out of the box without having to mark them @Serializable
 */
@Serializable
class ProjectEnum(val name: String, val status: Status,val secondStatus: SerStatus)

@OptIn(ExperimentalSerializationApi::class)
fun main() {
    val data = ProjectEnum("kotlinx.serialization", Status.SUPPORTED, SerStatus.NOT_SUPPORTED)
    println(Json.encodeToString(data))
}