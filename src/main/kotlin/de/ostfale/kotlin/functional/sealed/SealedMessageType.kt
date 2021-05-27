package de.ostfale.kotlin.functional.sealed

sealed class MessageType

class MessageSuccess(var msg: String) : MessageType()
class MessageFailure(var msg: String, var e: Exception) : MessageType()

fun main() {

    val messageSuccess = MessageSuccess("It worked!")
    val messageFailure = MessageFailure("Boo!", java.lang.Exception("Went wrong...!"))

    val failure = when (val myMessageFailure: MessageType = messageFailure) {
        is MessageSuccess -> myMessageFailure.msg
        is MessageFailure -> myMessageFailure.msg + " " + myMessageFailure.e.message
    }

    val success = when (val myMessageFailure: MessageType = messageSuccess) {
        is MessageSuccess -> myMessageFailure.msg
        is MessageFailure -> myMessageFailure.msg + " " + myMessageFailure.e.message
    }

    println("Failure message found: $failure")
    println("Success message found: $success")
}