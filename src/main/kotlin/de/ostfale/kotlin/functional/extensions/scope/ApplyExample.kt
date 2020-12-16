package de.ostfale.kotlin.functional.extensions.scope


/**
 * Use ‘apply’ for building or configuring objects
 *
 *  Definition: <code> inline fun <T> T.apply(lambda: T.() -> Unit): T </code>
 *
 * <ul>
 *     <li>https://medium.com/the-kotlin-chronicle/lets-also-apply-a-run-with-kotlin-on-our-minds-56f12eaef5e3</li>
 *     <li>https://kotlin.christmas/2020/3</li>
 * </ul>
 */

typealias Bundle = HashMap<String, Any>

fun Bundle.putString(key: String, value: String) {
    this[key] = value
}

fun Bundle.putInt(key: String, value: Int) {
    this[key] = value
}

abstract class Style

data class Notification(
    val style: Style,
    val extras: Bundle
) {
    class InboxStyle : Style()

    class Builder(context: Any, channelID: String) {
        lateinit var style: Style
        lateinit var extras: Bundle

        fun build(): Notification = Notification(style, extras)
    }
}

private const val EXTRA_ID = "extra_id"
private const val EXTRA_MAX_ITEMS = "extra_max_items"
private val context = Any()
private const val channel = "channel"

fun main() {
    val id = "ID"
    val maxSize = 20

    val extraBundle = Bundle().apply {
        putString(EXTRA_ID, id)
        putInt(EXTRA_MAX_ITEMS, maxSize)
    }

    val notification = Notification.Builder(context, channel).apply {
        style = Notification.InboxStyle()
        extras = extraBundle
    }.build()

    println(notification)
}