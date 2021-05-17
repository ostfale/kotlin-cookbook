package de.ostfale.kotlin.classes.properties

import de.ostfale.kotlin.classes.constructor.Point

class Polygon(vararg pts: Point) {
    private var _bbox: Polygon? = null

    val bbox
        get() = if (_bbox == null) setBox() else _bbox!!

    private fun setBox(): Polygon {
        // init variable lazy
        return Polygon()
    }
}
