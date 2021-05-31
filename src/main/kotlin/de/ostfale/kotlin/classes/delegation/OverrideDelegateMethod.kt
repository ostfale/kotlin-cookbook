package de.ostfale.kotlin.classes.delegation

class WindowOverrideMethod(val x: Int, val y: Int, private val bounds: Rectangle) : Geometry by bounds {
    override fun perimeter() = (bounds.w + bounds.h + 4) * 2
}