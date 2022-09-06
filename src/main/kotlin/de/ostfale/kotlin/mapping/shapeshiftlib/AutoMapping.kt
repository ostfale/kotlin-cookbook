package de.ostfale.kotlin.mapping.shapeshiftlib

import dev.krud.shapeshift.ShapeShiftBuilder
import dev.krud.shapeshift.dsl.mapper
import dev.krud.shapeshift.enums.AutoMappingStrategy
import dev.krud.shapeshift.transformer.DateToLongMappingTransformer
import java.time.Instant
import java.util.*

// https://dev.to/krud/object-mapping-advanced-features-qol-with-kotlin-5dgn
// https://shapeshift.krud.dev/
class SimpleUser {
    var id: String = ""
    var name: String? = null
    var email: String? = null
    var phone: String? = null
    // uses default transformer Date -> Long
    var birthDate: Date? = null
}

class SimpleUserDto {
    var id: String = ""
    var name: String? = null
    var email: String? = null
    var phone: String? = null
    var birthDate: Long? = null

    override fun toString(): String {
        return "SimpleUserDto(id='$id', name=$name, email=$email, phone=$phone, birthDate=$birthDate)"
    }
}

val simpleMapper = mapper<SimpleUser, SimpleUserDto> {
    // BY_NAME maps also fields of different types
    autoMap(AutoMappingStrategy.BY_NAME)
}

fun main() {
    val aUser = SimpleUser()
    aUser.id = "1"
    aUser.name = "Willi"
    aUser.birthDate = Date.from(Instant.now())

    val shapeShiftBuilder = ShapeShiftBuilder()
        .withMapping(simpleMapper.mappingDefinition).build()
    val result = shapeShiftBuilder.map<SimpleUser, SimpleUserDto>(aUser)
    assert(result.id == "1")
    assert(result.name == "Will")
    assert(result.birthDate is Long)

    println(result.toString())
}
