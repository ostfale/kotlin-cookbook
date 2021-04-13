package de.ostfale.kotlin.core.strings

val pws = listOf("12345", "123123123123", "abc123xyz", "sdfssfdafdafdf", "einGutesPasswort", "Lorem ipsum dolores est")

fun main() {
    for (pw in pws) {
        val n = testPassword(pw)
        val fmt = "Password: %-30s Punkte: %d"
        println(fmt.format(pw, n))
    }
}


fun testPassword(pw: String): Int {
    if (pw.length < 8) return 0
    if (pw.all { it.isDigit() }) return 0

    var result = 0
    val distinct = pw.toSet().size
    if (pw.length >= 10 && distinct >= 7) result++
    if (pw.length > 20) result++

    val special = "01234567890!$%§/(),;::-_#+*"
    for (c in pw) {
        if (c.isUpperCase() || special.contains(c)) {
            result++
            break
        }
    }
    val pwLower = pw.toLowerCase()
    result++
    val badWords = listOf("123", "111", "abc", "pass", "word", "qwe", "asd", "love", "login", "admin")
    for (word in badWords) {
        if (pwLower.contains(word)) {
            result--
            break
        }
    }
    return result
}
