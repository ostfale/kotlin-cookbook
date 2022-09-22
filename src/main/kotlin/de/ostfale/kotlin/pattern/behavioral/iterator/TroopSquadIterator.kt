import de.ostfale.kotlin.pattern.structural.bridge.*

fun main() {
    val platoon = Squad(
        StormTrooper(Rifle(), RegularLegs()),
        Squad(
            StormTrooper(Rifle(), RegularLegs()),
        ),
        StormTrooper(Rifle(), RegularLegs()),
        Squad(
            StormTrooper(Rifle(), RegularLegs()),
            StormTrooper(Rifle(), RegularLegs()),
        ),
        StormTrooper(Rifle(), RegularLegs()),
    )

    val l = listOf<String>()

    l.iterator()

    // For loop range must have an iterator method
    for (trooper in platoon) {
        println(trooper)
    }
}


class TrooperIterator(private val units: List<Trooper>) : Iterator<Trooper> {
    private var i = 0
    private var iterator: Iterator<Trooper> = this
    override fun hasNext(): Boolean {
        if (i >= units.size) {
            return false
        }
        if (i == units.size - 1) {
            if (iterator != this) {
                return iterator.hasNext()
            }
        }
        return true
    }

    override fun next(): Trooper {
        if (iterator != this) {
            if (iterator.hasNext()) {
                return iterator.next()
            } else {
                i++
                iterator = this
            }
        }

        return when (val e = units[i]) {
            is Squad -> {
                iterator = e.iterator()
                this.next()
            }

            else     -> {
                i++
                e
            }
        }
    }
}

class Squad(private val units: List<Trooper>) : Trooper {

    constructor(vararg units: Trooper) : this(units.toList())

    operator fun iterator(): Iterator<Trooper> {
        return TrooperIterator(units)
    }

    override fun move(x: Long, y: Long) {
        TODO("Not yet implemented")
    }

    override fun attackRebel(x: Long, y: Long) {
        TODO("Not yet implemented")
    }
}
