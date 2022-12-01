package de.ostfale.kotlin.coroutines.suspend

import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

suspend fun main() {
    val i: Int = suspendCoroutine { cont -> cont.resume(42) }; println(i) // 42
    val str: String = suspendCoroutine { cont -> cont.resume("Some text") }; println(str) // Some text
    val b: Boolean = suspendCoroutine { cont -> cont.resume(true) }; println(b) // true
}

/*suspend fun requestUser(any: Any): CoroutineUser {
    return suspendCoroutine<CoroutineUser> { cont ->
        requestUser { user :CoroutineUser->
            cont.resume(user)
        }
    }
}*/

data class CoroutineUser(
    val name: String
)
