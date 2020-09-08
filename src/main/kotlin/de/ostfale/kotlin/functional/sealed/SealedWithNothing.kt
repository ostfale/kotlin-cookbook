package de.ostfale.kotlin.functional.sealed

import de.ostfale.kotlin.functional.sealed.Restriction.*
import de.ostfale.kotlin.functional.sealed.Result.Failure
import de.ostfale.kotlin.functional.sealed.Result.Success
import org.slf4j.LoggerFactory

// Link: https://medium.com/@ultimate_guy/a-simple-real-world-example-of-nothing-in-kotlin-33f5d7d01fa6
fun main() {
    Handler().apply {
        handleWithInternalChecks()
        handleWithSealedObjects()
        handleWithSealedObjectAndNothing()
    }
}

sealed class Result<out T> {
    data class Success<out T>(val value: T) : Result<T>()
    data class Failure<out T>(val message: String) : Result<T>()

    inline infix fun check(block: (Failure<T>) -> Nothing): T {
        return when (this) {
            is Success -> this.value
            is Failure -> block(this)
        }
    }
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

    private fun getParameter(name: CHOICE, restriction: Restriction): Result<String> {
        val aValue: String? = getValue(name)
        return when (restriction) {
            is NotNull -> {
                if (aValue != null) Success(aValue) else Failure(NOT_PRESENT)
            }
            is NotBlank -> {
                if (aValue != null && aValue.isNotBlank()) Success(aValue) else Failure(NOT_PRESENT)
            }
            is AlphaNumeric -> {
                if (aValue != null && aValue.isNotBlank() && isAlphanumeric(aValue)) Success(aValue) else Failure(
                    NOT_PRESENT
                )
            }
        }
    }

    fun handleWithSealedObjectAndNothing() {

        val resultNotNull: String = getParameter(CHOICE.VALID, NotNull) check { result ->
            return log.info(
                "HANDLE::NOTHING : present {}",
                result.message
            )
        }
        log.info("HANDLE::NOTHING : present $resultNotNull")

        getParameter(CHOICE.NULL, NotNull) check { result ->
            return log.info(
                "HANDLE::NOTHING : not present {}",
                result.message
            )
        }

        val content = getParameter(CHOICE.VALID, NotBlank) check { result -> return log.info(result.message) }
        val noContent = getParameter(CHOICE.BLANK, NotBlank) check { result -> return log.info(result.message) }
        log.info("HANDLE::NOTHING : Get parameter is not blank: $content")
        log.info("HANDLE::NOTHING : Get parameter is  blank: $noContent")
    }

    fun handleWithSealedObjects() {
        log.info("HANDLE::Sealed: Get optional parameter found: ${getParameter(CHOICE.VALID, NotNull)}")
        log.info("HANDLE::Sealed: Get optional parameter not found: ${getParameter(CHOICE.NULL, NotNull)}")

        val present =
            when (val result = getParameter(CHOICE.VALID, NotNull)) {
                is Success -> result.value
                is Failure -> result.message
            }
        log.info("HANDLE::Sealed: Get value not null: $present")

        val content =
            when (val result = getParameter(CHOICE.BLANK, NotBlank)) {
                is Success -> result.value
                is Failure -> result.message
            }
        log.info("HANDLE::Sealed: Get value not blank: $content")

        val someHash =
            when (val result = getParameter(CHOICE.HASH, AlphaNumeric)) {
                is Success -> result.value
                is Failure -> result.message
            }
        log.info("HANDLE::Sealed: Get value is hash: $someHash")
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
    return src.all { it in '0'..'9' }
}

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

