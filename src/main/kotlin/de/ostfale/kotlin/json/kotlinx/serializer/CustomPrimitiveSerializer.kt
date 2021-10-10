package de.ostfale.kotlin.json.kotlinx.serializer

import kotlinx.serialization.*
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.json.Json

// https://github.com/Kotlin/kotlinx.serialization/blob/master/docs/serializers.md#primitive-serializer

/**
 * The next step is to bind a serializer to a class. This is done with the @Serializable annotation by
 * adding the with property value.
 */
@Serializable(with = ColorAsStringSerializer::class)
class ColorCustomSer(val rgb: Int)

/**
 * We want to serialize the Color class as a hex string with the green color represented as "00ff00".
 * To achieve this, we write an object that implements the KSerializer interface for the Color class.
 */
object ColorAsStringSerializer : KSerializer<ColorCustomSer> {
    override val descriptor: SerialDescriptor = PrimitiveSerialDescriptor("Color", PrimitiveKind.STRING)

    override fun serialize(encoder: Encoder, value: ColorCustomSer) {
        val string = value.rgb.toString(16).padStart(6, '0')
        encoder.encodeString(string)
    }

    override fun deserialize(decoder: Decoder): ColorCustomSer {
        val string = decoder.decodeString()
        return ColorCustomSer(string.toInt(16))
    }
}

@OptIn(ExperimentalSerializationApi::class)
fun main() {
    encode()
    decode()
}

@OptIn(ExperimentalSerializationApi::class)
private fun encode() {
    val green = ColorCustomSer(0x00ff00)
    println("Encode " + Json.encodeToString(green))
}

@OptIn(ExperimentalSerializationApi::class)
private fun decode() {
    val color = Json.decodeFromString<ColorCustomSer>("\"00ff00\"")
    println("Decode " + color.rgb) // prints 65280
}