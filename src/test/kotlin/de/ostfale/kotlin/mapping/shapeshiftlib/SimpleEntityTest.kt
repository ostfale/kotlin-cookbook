package de.ostfale.kotlin.mapping.shapeshiftlib

import dev.krud.shapeshift.ShapeShiftBuilder
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("Test ShapeShift Simple Mapper Functions")
internal class SimpleEntityTest {

    @Test
    internal fun testSimpleMapping() {
        val shapeShift = ShapeShiftBuilder().build()
        val simpleEntity = SimpleEntity("test", "test description", "private data")
        val result = shapeShift.map<SimpleEntity, SimpleEntityDisplay>(simpleEntity)
        assertEquals(result.name, "test")
        assertEquals(result.description, "test description")
    }

    @Test
    internal fun `test simple mapping with premade destination instance`() {
        val shapeShift = ShapeShiftBuilder().build()
        val simpleEntity = SimpleEntity("test", "test description", "private data")
        val result = shapeShift.map(simpleEntity, SimpleEntityDisplay())
        assertEquals(result.name, "test")
        assertEquals(result.description, "test description")
    }
}
