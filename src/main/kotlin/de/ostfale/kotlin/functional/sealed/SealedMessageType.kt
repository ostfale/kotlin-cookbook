package de.ostfale.kotlin.functional.sealed

import org.slf4j.LoggerFactory

sealed class MessageType

class MessageSuccess(var msg: String) : MessageType()
class MessageFailure(var msg: String, var e: Exception) : MessageType()


fun main() {
    val log = LoggerFactory.getLogger(MessageType::class.java)

    val messageSuccess = MessageSuccess("Yay!")
    val messageSuccess2 = MessageSuccess("It worked!")
    val messageFailure = MessageFailure("Boo!", java.lang.Exception("Went wrong...!"))

    val myMessage = when (val myMessageFailure: MessageType = messageFailure) {
        is MessageSuccess -> myMessageFailure.msg
        is MessageFailure -> myMessageFailure.msg + " " + myMessageFailure.e.message
    }

    log.info("Message found: $myMessage")
}