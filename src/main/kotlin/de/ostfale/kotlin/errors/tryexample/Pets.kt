package de.ostfale.kotlin.errors.tryexample

data class Pet(
    val name: String,
    val age: Int,
    val type: PetType
)

fun toPet(values: List<String>): Try<Pet> {
    val name = values[0]
    val ageTry: Try<Int> = Try { values[1].toInt() }
    val typeTry: Try<PetType> = PetType.lookup(values[2])

    return ageTry.flatMap { age -> typeTry.map { type -> Pet(name, age, type) } }
}


enum class PetType(val type: String) {

    Cat("Cat"),
    Dog("Dog"),
    Ferret("Ferret");

    companion object {
        private val mapping = values().associateBy(PetType::type)
        fun lookup(type: String) = Try { mapping[type] ?: throw Exception("No Pet Type: $type") }
    }
}


// ###############  First implementation without using Try ###########################

data class PetBasic(
    val name: String,
    val age: Int,
    val type: PetTypeBasic
)

fun toPetBasic(values: List<String>): PetBasic {
    val name = values[0]
    val age = values[1].toInt()
    val type = PetTypeBasic.lookup(values[2])
    return PetBasic(name, age, type)
}

enum class PetTypeBasic(val type: String) {
    Cat("Cat"), Dog("Dog"), Ferret("Ferret");

    companion object {
        private val mapping = values().associateBy(PetTypeBasic::type)
        fun lookup(type: String) = mapping[type] ?: throw Exception("No Pet Type: $type")
    }
}