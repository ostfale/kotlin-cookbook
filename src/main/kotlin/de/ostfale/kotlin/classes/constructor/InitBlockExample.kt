package de.ostfale.kotlin.classes.constructor

class Point(var x: Double, var y: Double)

class Polygon(vararg points: Point) {
    private val pts: List<Point>

    init {
        if (points.count() < 3) {
            val msg = "Needs at least 3 points!"
            throw IllegalArgumentException(msg)
        }
        this.pts = points.toList()
    }

    fun center(): Point {
        val centerX = pts.sumOf { it.x } / pts.count().toDouble()
        val centerY = pts.sumOf { it.y } / pts.count().toDouble()
        return Point(centerX, centerY)
    }
}

fun main() {
    val p1 = Point(0.0, 0.0)
    val p2 = Point(5.0, 1.0)
    val p3 = Point(4.0, 4.0)
    val p4 = Point(1.0, 3.0)
    val polygon = Polygon(p1, p2, p3, p4)
    val c = polygon.center()
    println("Center point x=${c.x} y=${c.y} ")
}