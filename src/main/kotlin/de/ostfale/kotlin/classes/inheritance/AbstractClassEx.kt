package de.ostfale.kotlin.classes.inheritance

abstract class AAbstract(val p1: Int, val p2: Int) {
    abstract fun m(): Int
}

class BAbstract(p1: Int, p2: Int) : AAbstract(p1, p2) {
    override fun m() = p1 + p2
}