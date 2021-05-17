package de.ostfale.kotlin.classes.properties

import de.ostfale.kotlin.classes.constructor.Point

class PolygonLate(vararg pts: Point) {
    private lateinit var _bbox: Polygon

    val bbox
        get() = if (!::_bbox.isInitialized) setBox() else _bbox

    private fun setBox(): Polygon {
        // init variable lazy
        return Polygon()
    }
}