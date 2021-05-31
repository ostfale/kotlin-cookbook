package de.ostfale.kotlin.meta.reflection

import kotlin.reflect.full.allSupertypes

open class Person(val name: String)

interface TeamLeader {
    var team: List<Employee>
}

class Employee(name: String, val salaray: Int) : Person(name), TeamLeader {
    override var team = listOf<Employee>()
}

fun main() {
    getMetaInfo()
}

fun getMetaInfo() {
    val kc = Person::class  // KClass<Person>
    println("Class is open: ${kc.isOpen}")
    println("Class is data: ${kc.isData}")
    println("Show members: ${kc.members}")
    println("Show supertypes: ${kc.allSupertypes}")
}
