package de.ostfale.kotlin.mapping.shapeshiftlib

import dev.krud.shapeshift.dsl.mapper
import dev.krud.shapeshift.enums.AutoMappingStrategy
import java.util.*


class User {
    var id: String = ""
    var name: String? = null
    var birthDate: Date? = null
}

class UserDTO {
    var id: String = ""
    var fullName: String? = null
    var birthDate: Long? = null
}

val mapper = mapper<User, UserDTO> {
    autoMap(AutoMappingStrategy.BY_NAME)
}
