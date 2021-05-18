package de.ostfale.kotlin.classes.objects

class Vector(val x: Double, val y: Double, val z: Double) {
    companion object {
        val nullV get() = Vector(0.0, 0.0, 0.0)
        val unitV get() = Vector(1.0, 1.0, 1.0)

        fun add(v1: Vector, v2: Vector): Vector {
            return Vector(v1.x + v2.x, v1.y + v2.y, v1.z + v2.z)
        }
    }

    override fun toString(): String {
        return "($x / $y / $z)"
    }
}

fun main() {
    val v1 = Vector(1.2, 7.4, 2.5)
    val v2 = Vector.unitV
    val v3 = Vector.add(v1, v2)
    println("Vector sum: $v3")
}