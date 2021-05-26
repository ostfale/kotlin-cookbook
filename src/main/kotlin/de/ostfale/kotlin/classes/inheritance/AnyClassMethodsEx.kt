package de.ostfale.kotlin.classes.inheritance

class AnyClass(val n: Int, val x: Double) {
    override fun equals(other: Any?): Boolean {
        return if (other is AnyClass) {
            n == other.n && x == other.x
        } else
            false
    }

    override fun hashCode(): Int {
        return n.hashCode().xor(x.hashCode())
    }

    override fun toString(): String {
        return "A(n=$n, x=$x"
    }
}