package de.ostfale.kotlin.pattern.delegation

import kotlin.reflect.KProperty

fun main() {
    usePoliteString()
}

class PoliteString(var content: String) {
    operator fun getValue(thisRef: Any?, property: KProperty<*>) = content.replace("stupid", "s*****")
    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {
        content = value
    }
}

fun beingPolite(content: String) = PoliteString(content)

fun usePoliteString() {
    // var comment: String by PoliteString("Some nice message...")
    var comment: String by beingPolite("Some nicer message...")
    println(comment)
    comment = "This is stupid..."
    println(comment)
    println("Comment is of length: ${comment.length}")
}