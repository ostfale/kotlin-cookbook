package de.ostfale.kotlin.functional.extensions.helper

import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject
import java.security.MessageDigest
import java.util.regex.Pattern

fun main() {
    emailTest()
    md5ShaTest()
    testNumberDigits()
    testJsonConversion()
    testLastPathComponent()
    testCreditCardFormatedString()
}


fun String.isEmailValid(): Boolean {
    val expression = "^[\\w.-]+@([\\w\\-]+\\.)+[A-Z]{2,8}$"
    val pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE)
    val matcher = pattern.matcher(this)
    return matcher.matches()
}

fun emailTest() {
    val validEmail = "test@email.com"
    val invalidEmail = "test@email"

    println("Is email $validEmail valid: ${validEmail.isEmailValid()}")
    println("Is email $invalidEmail valid: ${invalidEmail.isEmailValid()}")
}

val String.md5: String
    get() {
        val bytes = MessageDigest.getInstance("MD5").digest(this.toByteArray())
        return bytes.joinToString("") { "%02x".format(it) }
    }

val String.sha1: String
    get() {
        val bytes = MessageDigest.getInstance("SHA-1").digest(this.toByteArray())
        return bytes.joinToString("") { "%02x".format(it) }
    }

fun md5ShaTest() {
    val md5Hash = "test".md5
    val sha1Hash = "test".sha1

    println("MD5 of string test :  $md5Hash")
    println("SHA-1 of string test :  $sha1Hash")
}

val String.containsLatinLetter: Boolean
    get() = matches(Regex(".*[A-Za-z].*"))

val String.containsDigit: Boolean
    get() = matches(Regex(".*[0-9].*"))

val String.isAlphanumeric: Boolean
    get() = matches(Regex("[A-Za-z0-9]*"))

val String.hasLettersAndDigits: Boolean
    get() = containsLatinLetter && containsDigit

val String.isIntegerNumber: Boolean
    get() = toIntOrNull() != null

val String.toDecimalNumber: Boolean
    get() = toDoubleOrNull() != null

fun testNumberDigits() {
    println("Contains letters".containsLatinLetter) // true
    println("12345".containsLatinLetter) // false
    println("Contains digits 123".containsDigit)// true
    println("123".isIntegerNumber)// true
    println("12.9".toDecimalNumber) // true
}

val String.jsonObject: JSONObject?
    get() = try {
        JSONObject(this)
    } catch (e: JSONException) {
        null
    }

val String.jsonArray: JSONArray?
    get() = try {
        JSONArray(this)
    } catch (e: JSONException) {
        null
    }

fun testJsonConversion() {
    val json = "{\"key\": \"value\"}".jsonObject  // {"key": "value"}
    val jsonAgain = json?.toString() // "{"key": "value"}"
    val stringFromJson = json?.getString("key") // "value"

    println("Create JSON object from String: $json")
    println("Create String from JSON object above: $jsonAgain")
    println("Read value from JSON object: ${json?.getString("key")}")
}

val String.lastPathComponent: String
    get() {
        var path = this
        if (path.endsWith("/"))
            path = path.substring(0, path.length - 1)
        var index = path.lastIndexOf('/')
        if (index < 0) {
            if (path.endsWith("\\"))
                path = path.substring(0, path.length - 1)
            index = path.lastIndexOf('\\')
            if (index < 0)
                return path
        }
        return path.substring(index + 1)
    }

fun testLastPathComponent() {
    val lpc1 = "https://google.com/chrome/".lastPathComponent // chrome
    val lpc2 = "C:\\Windows\\Fonts\\font.ttf".lastPathComponent // font.ttf
    val lpc3 = "/dev/null".lastPathComponent // null

    println("Last path component in URL: $lpc1")
    println("Last path component in win path: $lpc2")
    println("Last path component in unix path: $lpc3")
}

val String.creditCardFormatted: String
    get() {
        val preparedString = replace(" ", "").trim()
        val result = StringBuilder()
        for (i in preparedString.indices) {
            if (i % 4 == 0 && i != 0) {
                result.append(" ")
            }
            result.append(preparedString[i])
        }
        return result.toString()
    }

fun testCreditCardFormatedString() {
    val ccFormatted = "1234567890123456".creditCardFormatted // "1234 5678 9012 3456"
    println("Format 1234567890123456 to: $ccFormatted")
}