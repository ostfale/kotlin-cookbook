package de.ostfale.kotlin.functional.extensions

/**
 * Use ‘also’ for executing side-effects on objects
 *
 *  Definition: <code> inline fun <T> T.also(lambda: (T) -> Unit): T </code>
 *
 * <ul>
 *     <li>https://medium.com/the-kotlin-chronicle/lets-also-apply-a-run-with-kotlin-on-our-minds-56f12eaef5e3</li>
 * </ul>
 */

// base declaration in ApplyExample

private const val EXTRA_ID = "extra_id"
private const val EXTRA_MAX_ITEMS = "extra_max_items"

fun main() {
    example()
}

fun example(): Notification {
    val context = Any()
    val channel = "channel"

    val id = "AnotherID"
    val maxSize = 200


    val extraBundle = Bundle().apply {
        putString(EXTRA_ID, id)
        putInt(EXTRA_MAX_ITEMS, maxSize)
    }

    val notification = Notification.Builder(context, channel).apply {
        style = Notification.InboxStyle()
        extras = extraBundle
    }.build()

    return notification.also {
        println(it)
    }
}