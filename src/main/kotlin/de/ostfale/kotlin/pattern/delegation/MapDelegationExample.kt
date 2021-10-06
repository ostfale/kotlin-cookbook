package de.ostfale.kotlin.pattern.delegation

import kotlin.reflect.KProperty

class PoliteStringMap(private val dataSource: MutableMap<String, Any>) {
    operator fun getValue(thisRef: Any?, property: KProperty<*>) =
        (dataSource[property.name] as? String)?.replace("stupid", "s*****") ?: ""

    operator fun setValue(thisRef: Any, property: KProperty<*>, value: String) {
        dataSource[property.name] = value
    }
}

class PostComment(dataSource: MutableMap<String, Any>) {
    private val title: String by dataSource
    var likes: Int by dataSource
    private val comment: String by PoliteStringMap(dataSource)

    override fun toString() = "Title: $title Likes: $likes Comment: $comment"
}

fun main() {
    val data1 : MutableMap<String, Any> = mutableMapOf(
        "title" to "Using Delegation",
        "likes" to 2,
        "comment" to "Keep it simple, stupid")

    val data2 : MutableMap<String, Any> = mutableMapOf(
        "title" to "Using Inheritance",
        "likes" to 1,
        "comment" to "Prefer Delegation where possible"
    )

    val forPost1 = PostComment(data1)
    val forPost2 = PostComment(data2)

    forPost1.likes++

    println(forPost1)
    println(forPost2)
}
