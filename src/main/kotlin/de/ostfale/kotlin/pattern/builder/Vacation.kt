package de.ostfale.kotlin.pattern.builder

import org.slf4j.LoggerFactory

class Vacation(builder: VacationBuilder) {

    private var hotel: String = ""
    private var excursions: List<String> = listOf()
    private var cuisine: List<String> = listOf()

    init {
        hotel = builder.hotel
        excursions = builder.excursions
        cuisine = builder.cuisine
    }

    class VacationBuilder {
        var hotel: String = ""
        var excursions: List<String> = listOf()
        var cuisine: List<String> = listOf()

        fun withHotel(value: String): VacationBuilder {
            this.hotel = value
            return this
        }

        fun withExcursions(value: List<String>): VacationBuilder {
            this.excursions = value
            return this
        }

        fun withCuisine(value: List<String>): VacationBuilder {
            this.cuisine = value
            return this
        }

        fun build(): Vacation = Vacation(this)
    }

    override fun toString(): String {
        return "Vacation(hotel='$hotel', excursions=$excursions, cuisine=$cuisine)"
    }
}

fun main() {
    val vacation: Vacation = Vacation.VacationBuilder()
        .withHotel("Hilton")
        .withExcursions(listOf("running", "swimming"))
        .withCuisine(listOf("italian", "asian"))
        .build()

    println("My vacation: $vacation")
}