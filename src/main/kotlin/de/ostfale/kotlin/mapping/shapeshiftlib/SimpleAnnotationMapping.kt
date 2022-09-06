package de.ostfale.kotlin.mapping.shapeshiftlib

import dev.krud.shapeshift.ShapeShiftBuilder
import dev.krud.shapeshift.resolver.annotation.DefaultMappingTarget
import dev.krud.shapeshift.resolver.annotation.MappedField

data class SimpleEntityDisplay(
    val name: String = "",
    val description: String = ""
)

@DefaultMappingTarget(SimpleEntityDisplay::class)
data class SimpleEntity(
    @MappedField
    val name: String,
    @MappedField
    val description: String,
    val privateData: String
)

fun main() {
    val shapeShift = ShapeShiftBuilder().build()

    val simpleEntity = SimpleEntity("test", "test description", "private data")
    val simpleEntityDisplay = shapeShift.map<SimpleEntity, SimpleEntityDisplay>(simpleEntity)
    // -> test
}
