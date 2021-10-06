package de.ostfale.kotlin.json.kotlinx.builtin

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.Serializable
import kotlinx.serialization.builtins.LongAsStringSerializer
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

// https://github.com/Kotlin/kotlinx.serialization/blob/master/docs/builtin-classes.md

/**
 * The full range of a Kotlin Long does not fit in the JavaScript number, so its precision gets lost in JavaScript.
 * A common workaround is to represent long numbers with full precision using the JSON string type. This approach is
 * optionally supported by Kotlin Serialization with LongAsStringSerializer, which can be specified for a given Long
 * property using the @Serializable annotation:
 */
@Serializable
class DataLong(
    val signature: Long,
    @Serializable(with = LongAsStringSerializer::class)
    val sigAsSTring: Long
)

@OptIn(ExperimentalSerializationApi::class)
fun main() {
    val data = DataLong(0x1CAFE2FEED0BABE0, 0x1CAFE2FEED0BABE0)
    println(Json.encodeToString(data))
}