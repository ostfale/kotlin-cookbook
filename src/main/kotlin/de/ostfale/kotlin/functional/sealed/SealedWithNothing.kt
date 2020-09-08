package de.ostfale.kotlin.functional.sealed

import org.slf4j.LoggerFactory

fun main() {
    Handler().apply {
        handleWithInternalChecks()
    }
}

sealed class Result<out T> {
    data class Success<out T>(val value: T) : Result<T>()
    data class Failure<out T>(val message: String) : Result<T>()
}

sealed class Restriction {
    object NotNull : Restriction()
    object NotBlank : Restriction()
    object AlphaNumeric : Restriction()
}


class Handler() {

    private val log = LoggerFactory.getLogger(javaClass)


    private fun getParameter(name: CHOICE): String? {
        return getValue(name)
    }

    fun handleWithInternalChecks() {
        log.info("HANDLE::BASIC: Get optional parameter found: ${getParameter(CHOICE.VALID)}")
        log.info("HANDLE::BASIC: Get optional parameter not found: ${getParameter(CHOICE.NULL)}")

        log.info(
            "HANDLE::BASIC: Get present parameter found: {}",
            getParameter(CHOICE.VALID) ?: NOT_PRESENT
        )

        log.info(
            "HANDLE::BASIC: Get present parameter not found: {}",
            getParameter(CHOICE.NULL) ?: NOT_PRESENT
        )

        val contentFound = getParameter(CHOICE.VALID) ?: NOT_PRESENT
        val contentBlank = getParameter(CHOICE.BLANK) ?: NOT_PRESENT

        if (contentFound.isBlank()) log.info("HANDLE::BASIC: Content is provided but empty!")
        if (contentBlank.isBlank()) log.info("HANDLE::BASIC: Content is provided but empty!")

        val someHash = getParameter(CHOICE.HASH) ?: NOT_PRESENT
        val someHashBlank = getParameter(CHOICE.BLANK) ?: NOT_PRESENT

        if (someHash.isNotBlank() && isAlphanumeric(someHash)) log.info("HANDLE::BASIC: Hash found: $someHash ")
        if (someHashBlank.isBlank() || isAlphanumeric(someHashBlank)) log.info("HANDLE::BASIC: Hash found: $someHashBlank ")
    }


}

fun isAlphanumeric(src: String): Boolean {
    return src.all{ it in '0'..'9'}
}

/*fun getParameter(name: String, restriction: Restriction): Result<String> {

}*/

fun getValue(param: CHOICE): String? {
    return when (param) {
        CHOICE.VALID -> "valid string"
        CHOICE.BLANK -> " "
        CHOICE.HASH -> "value".hashCode().toString()
        CHOICE.NULL -> null
    }
}

enum class CHOICE {
    VALID, NULL, BLANK, HASH
}

const val NOT_PRESENT = "Value was not present"

