package de.ostfale.kotlin.functional.extensions.helper

import org.json.JSONException
import org.json.JSONObject
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

fun Int.toDate(): Date = Date(this.toLong() * 1000L)

val Int.asDate: Date
    get() = Date(this.toLong() * 1000L)

fun String.toDate(format: String): Date? {
    val dateFormatter = SimpleDateFormat(format, Locale.US)
    return try {
        dateFormatter.parse(this)
    } catch (e: ParseException) {
        null
    }
}

fun Date.toString(format: String): String {
    val dateFormatter = SimpleDateFormat(format, Locale.US)
    return dateFormatter.format(this)
}

fun JSONObject.getIntOrNull(name: String): Int? =
    try {
        getInt(name)
    } catch (e: JSONException) {
        val strValue = getStringOrNull(name)
        strValue?.toIntOrNull()
    }

fun JSONObject.getStringOrNull(name: String): String? =
    try {
        getString(name).trim()
    } catch (e: JSONException) {
        null
    }

fun main() {
    testIntDateExtension()
    testStringDateConversion()
}

fun testIntDateExtension() {
    val json = JSONObject();
    json.put("date", 1598435781)

    val date = json.getIntOrNull("date")?.asDate
    println("Read int date 1598435781 into date object: $date")
}

fun testStringDateConversion() {
    val format = "dd-MM-yyyy HH:mm:ss"
    val date = Date()
    val str = date.toString(format)
    val date2 = str.toDate(format)

    println ("Create formatted date to string: $str")
    println ("Create formatted string to date: $date2")
}
