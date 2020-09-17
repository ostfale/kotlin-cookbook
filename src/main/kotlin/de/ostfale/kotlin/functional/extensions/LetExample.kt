package de.ostfale.kotlin.functional.extensions

import org.slf4j.Logger
import org.slf4j.LoggerFactory

/**
 * Use ‘let’ for transforming nullable properties
 *
 *  Definition: <code> inline fun <T, R> T.let(lambda: (T) -> R): R </code>
 *
 * <ul>
 *     <li>https://medium.com/the-kotlin-chronicle/lets-also-apply-a-run-with-kotlin-on-our-minds-56f12eaef5e3</li>
 * </ul>
 */
class Mapper {

    val log: Logger = LoggerFactory.getLogger(Mapper::class.java)

    private val mapProperty: Map<String, Int>? = mapOf("key1" to 4, "key2" to 20)

    private fun toLogString(): String {
        return mapProperty?.let {
            val count = it.size
            val keys = it.keys
            val values = it.values
            "Map has $count keys $keys and values $values"
        } ?: "Map is empty"
    }

    fun println() {
        log.info("Output mapper: {}", toLogString())
    }
}

fun main() {
    Mapper().println()
}