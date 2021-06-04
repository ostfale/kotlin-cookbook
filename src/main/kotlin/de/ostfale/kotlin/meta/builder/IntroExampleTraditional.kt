package de.ostfale.kotlin.meta.builder

class Person(val name: String, private val title: String, private val team: MutableList<Person> = mutableListOf()) {

    private fun render(builder: StringBuilder, indent: String = "") {
        builder.append("$indent$name ($title)\n")
        team.sortedBy { it.name }.forEach { it.render(builder, "$indent    ") }
    }

    override fun toString(): String {
        val builder = StringBuilder()
        render(builder)
        return builder.toString()
    }
}

fun main() {
    traditionalInit()
}

private fun traditionalInit() {
    val feTeam = mutableListOf(Person("S.", "Software Developer"), Person("Carter", "Quality Control & Test"))
    val devLeader = Person("Miller", "Lead F&E", feTeam)
    val distLeader = Person("Berger", "Lead Distribution")
    val purchLeader = Person("Wells", "Lead Finance")
    val all = Person("Huber", "CEO", mutableListOf(devLeader, distLeader, purchLeader))
    println(all)
}