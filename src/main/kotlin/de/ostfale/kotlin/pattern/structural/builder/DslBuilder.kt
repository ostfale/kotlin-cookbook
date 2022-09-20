package de.ostfale.kotlin.pattern.structural.builder

class Car(
    val model: String?,
    val year: Int,
    var required: String
) {
    private constructor(builder: Builder) : this(builder.model, builder.year, builder.required)

    companion object {
        inline fun build(required: String, block: Builder.() -> Unit) = Builder(required).apply(block).build()
    }

    class Builder(
        val required: String
    ) {
        var model: String? = null
        var year: Int = 0

        fun build() = Car(this)
    }
}

fun main() {
    val car = Car.build(required = "required Value") { model = "X" }
    println("Car = $car")
}
