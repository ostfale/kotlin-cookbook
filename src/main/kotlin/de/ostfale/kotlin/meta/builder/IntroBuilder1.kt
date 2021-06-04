package de.ostfale.kotlin.meta.builder

class PersonV1(
    var name: String = "missing name",
    var title: String = "missing title",
    var team: MutableList<PersonV1> = mutableListOf(),
) {
    private fun render(builder: StringBuilder, indent: String = "") {
        builder.append("$indent$name ($title)\n")
        team.sortedBy { it.name }.forEach { it.render(builder, "$indent    ") }
    }

    fun teamMember(initFn: PersonV1.() -> Unit) =
        PersonV1().also { newPerson ->
            newPerson.initFn()
            team.add(newPerson)
        }

    override fun toString(): String {
        val builder = StringBuilder()
        render(builder)
        return builder.toString()
    }
}

fun person1(initFn: PersonV1.() -> Unit) = PersonV1().apply { initFn() }

fun main() {
    initTeam()
}

fun initTeam() {
    val all = person1 {
        name = "Huber"
        title = "CEO"

        teamMember {
            name = "Miller"
            title = "Lead F&E"

            teamMember {
                name = "Smith"
                title = "Software Developer"
            }

            teamMember {
                name = "Carter"
                title = "Quality Control & Test"
            }
        }
        teamMember {
            name = "Berger"
            title = "Lead Distribution"
        }

        teamMember {
            name = "Wells"
            title = "Lead Finance"
        }
    }
    println(all)
}
