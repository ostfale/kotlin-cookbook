package de.ostfale.kotlin.pattern.behavioral.chainresponsibility

typealias Handler = (request: Request) -> Response

data class Response(val answer: String)

data class Request(val email: String, val question: String) {
    fun isKnownEmail(): Boolean {
        return true
    }

    fun isFromJuniorDeveloper(): Boolean {
        return false
    }
}

val juniorDeveloper = fun(next: Handler) =
    fun(request: Request): Response {
        if (request.isFromJuniorDeveloper()) {
            throw IllegalArgumentException()
        }
        println("Junior developer passed...")
        return next(request)
    }

val authentication = fun(next: Handler) =
    fun(request: Request): Response {
        if (!request.isKnownEmail()) {
            throw IllegalArgumentException()
        }
        println("Authentication passed...")
        return next(request)
    }

val basicValidation = fun(next: Handler) =
    fun(request: Request): Response {
        if (request.email.isEmpty() || request.question.isEmpty()) {
            throw IllegalArgumentException()
        }
        println("Validation passed...")
        return next(request)
    }

val finalResponse = fun() =
    fun(_: Request): Response {
        return Response("I don't know")
    }


fun main() {
    val req = Request(
        "developer@company.com",
        "Why do we need Software Architects?"
    )

    val chain = basicValidation(authentication(juniorDeveloper(finalResponse())))
    val res = chain(req)
    println(res)
}
