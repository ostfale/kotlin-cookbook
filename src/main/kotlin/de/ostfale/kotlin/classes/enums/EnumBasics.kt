package de.ostfale.kotlin.classes.enums

// https://typealias.com/start/kotlin-enum-classes/

enum class PetTypeBasic(val type: String) {
    Cat("Cat"), Dog("Dog"), Ferret("Ferret");

    companion object {
        private val mapping = values().associateBy(PetTypeBasic::type)
        fun lookup(type: String) = mapping[type] ?: throw Exception("No Pet Type: $type")
    }
}