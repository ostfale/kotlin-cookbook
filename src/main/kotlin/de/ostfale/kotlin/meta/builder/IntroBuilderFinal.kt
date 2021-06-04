package de.ostfale.kotlin.meta.builder

@DslMarker
annotation class MyDsl

@MyDsl
class PersonFinal(val name: String, val title: String, val team: MutableList<PersonFinal> = mutableListOf()) {

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

@MyDsl
class PersonBuilder {
    var name: String? = null
    var title: String? = null
    var team = mutableListOf<PersonFinal>()

    fun teamMember(initFn: PersonBuilder.() -> Unit) =
        PersonBuilder().also { newPerson ->
            newPerson.initFn()
            team.add(newPerson.build())
        }

    fun build(): PersonFinal {
        if (name is String && title is String)
            return PersonFinal(name!!, title!!, team)
        else
            throw IllegalArgumentException("Not all props initialized")
    }
}

fun personFinal(initFn: PersonBuilder.() -> Unit) =
    PersonBuilder().apply { initFn() }.build()

fun main() {
    initTeamFinal()
}

fun initTeamFinal() {
    val all = personFinal {
        name = "Schubert"
        title = "CEO / CTO"

        teamMember {
            name = "Jelinek"
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