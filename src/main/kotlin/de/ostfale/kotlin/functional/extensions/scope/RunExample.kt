package de.ostfale.kotlin.functional.extensions.scope

/**
 * Use ‘run’ for transforming objects
 * This allows the function to transform the receiver of type T into a value of type R that was returned by the lambda.
 *
 *  Definition: <code> inline fun <T, R> T.run(lambda: T.() -> R): R </code>
 *
 * <ul>
 *     <li>https://medium.com/the-kotlin-chronicle/lets-also-apply-a-run-with-kotlin-on-our-minds-56f12eaef5e3</li>
 * </ul>
 */
fun main() {
    val map = mapOf("key1" to 4, "key2" to 20)

    val logItem = map.run {
        val count = size
        val keys = keys
        val values = values
        "Map has $count keys $keys and values $values"
    }
    println(logItem)
}