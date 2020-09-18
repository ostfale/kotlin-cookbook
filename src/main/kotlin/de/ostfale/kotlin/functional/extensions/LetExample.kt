package de.ostfale.kotlin.functional.extensions

import org.slf4j.Logger
import org.slf4j.LoggerFactory

/**
 * Use ‘let’ for transforming nullable properties
 * We can call let() function on any type of object, in the above example as we can see we are calling a safe call
 * using ?., in this scenario, let() is only called when the value of name is not null or empty or else the function
 * will skip printing the length of the name. The let() is useful in the case where we want to perform many operations
 * on the variable. When a variable is not null simply proceed or else just skip that operation.
 *
 *  Definition: <code> inline fun <T, R> T.let(lambda: (T) -> R): R </code>
 *
 * <ul>
 *     <li>https://medium.com/the-kotlin-chronicle/lets-also-apply-a-run-with-kotlin-on-our-minds-56f12eaef5e3</li>
 *     <li>https://medium.com/swlh/what-are-the-kotlin-scope-functions-ff2e082fa03b</li>
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