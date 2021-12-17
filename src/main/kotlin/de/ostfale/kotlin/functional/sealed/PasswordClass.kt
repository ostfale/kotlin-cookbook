package de.ostfale.kotlin.functional.sealed

// Link: https://medium.com/swlh/value-based-classes-and-error-handling-in-kotlin-3f14727c0565

/**
 *
 * Returning null in this case is barely helpful. What do we tell the app user? bad password?
 */
data class PasswordBasic private constructor(val value: String) {
    companion object {
        fun of(value: String): PasswordBasic? {
            return if (value.isGoodPassword()) PasswordBasic(value) else null
        }
    }
}

/**
 * All the try-catching aside, what happens when we decide we need to add seventy-five more constraints on our
 * user’s passwords? We add the exceptions, update our documentations and .. start asking who has been instantiating
 * our class?
 */
data class PasswordWithExceptions private constructor(val value: String) {
    companion object {
        fun of(value: String): PasswordWithExceptions {
            return when {
                value.isTooShort() -> throw PasswordTooShortException()
                value.containsNoNumbers() -> throw PasswordContainsNoNumbersException()
                else -> PasswordWithExceptions(value)
            }
        }
    }
}

/**
 * By using sum types (Either), sealed classes and exhaustive when, the compiler is now responsible for maintaining
 * our code and will force us (unless explicitly told not to) to handle all the error scenarios wherever we instantiate
 * this class.
 */
/*data class PasswordAlgebraicDataType private constructor(val value: String) {
    companion object {
        fun of(value: String): Either<Violation, PasswordAlgebraicDataType> {
            return when {
                value.isTooShort() -> Violation.PasswordTooShort(MIN_LENGTH).left()
                value.containsNoNumbers() -> Violation.PasswordContainsNoNumbers.left()
                else -> PasswordAlgebraicDataType(value).right()
            }
        }
    }
}*/


/**
 * The copy method of Kotlin’s data classes breaks our invariants, it can bypass all of our rules and it can
 * create “illegal” instances of our class.It is a well-known design flaw in the language, with no apparent way to
 * fix it, while keeping backward-compatibility.
 */
// @NoCopy   -> needs a gradle plugin https://github.com/AhmedMourad0/no-copy/
/*data class Password constructor(val value: String) {
    companion object {
        @ExperimentalStdlibApi
        fun of(value: String): Either<List<Violation>, Password> {
            val violations = buildList {
                if (value.isTooShort()) {
                    add(Violation.PasswordTooShort(MIN_LENGTH))
                }
                if (value.containsNoNumbers()) {
                    add(Violation.PasswordContainsNoNumbers)
                }
            }
            return if (violations.isEmpty()) Password(value).right() else violations.left()
        }
    }
}*/

@ExperimentalStdlibApi
fun main() {
//    val password: Either<List<Violation>, Password> = Password.of("Some34Really434Hard21Password!").orThrow()  //Throw on violation just for demonstration
//    val haha = password.copy(value = "gotcha") //Unresolved reference: copy
}

const val MIN_LENGTH = 16

sealed class Violation {
    data class PasswordTooShort(val minLength: Int) : Violation()
    object PasswordContainsNoNumbers : Violation()
}

private fun String.isGoodPassword(): Boolean {
    return true
}

private fun String.isTooShort(): Boolean {
    return false
}

private fun String.containsNoNumbers(): Boolean {
    return true
}

class PasswordTooShortException() : Exception("Password is too short!")
class PasswordContainsNoNumbersException() : Exception("Password contains no numbers!")