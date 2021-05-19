package de.ostfale.kotlin.classes.inheritance

open class AProp() {
    open val prop
        get() = 123
}

class BProp() : AProp() {
    override val prop: Int
        get() = 300
}

fun main() {
    val obj = BProp()
    println("Overridden BProp: ${obj.prop}")
}