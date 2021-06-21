package de.ostfale.kotlin.json

import kotlinx.serialization.Serializable

@Serializable
class Choice(val txt: String, val ok: Boolean)

@Serializable
class Question(val txt: String, val choices: List<Choice>)
