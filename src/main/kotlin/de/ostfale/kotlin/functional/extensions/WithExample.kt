package de.ostfale.kotlin.functional.extensions

/**
 * Use ‘with’ to avoid writing the same receiver over and over again
 *
 * The with function is like the run function but it does not have a receiver. Instead, it takes a ‘receiver’
 * as its first parameter and the lambda-with-receiver as its second parameter.<br>
 *   1. Provides its first parameter to the lambda’s receiver Inside the lambda, the receiver can be used through the
 *   optional keyword this
 *   2. Calls the lambda and get its result We no longer need to write the same receiver over and over again because
 *   the receiver is represented by the optional keyword this
 *   3. Returns the result of the lambda Although the receiver of type T is transformed into a value of type R ,
 *   the return value of a with function is usually ignored
 *
 *  Definition: <code> inline fun <T, R> with(receiver: T, block: T.() -> R): R </code>
 *
 * <ul>
 *     <li>https://medium.com/the-kotlin-chronicle/lets-also-apply-a-run-with-kotlin-on-our-minds-56f12eaef5e3</li>
 * </ul>
 */
class RemoteReceiver {
    private fun remoteControl(id: String): RemoteControl = TODO()

    private val hdmiIn2 = 2
    private val hdmiOut1 = 1
    private val passTrough = 1

    fun turnOnAction(remoteControlId: String): Unit {
        val remoteControl = remoteControl(remoteControlId)
        with(remoteControl) {
            turnOnAV()
            selectInput(hdmiIn2)
            selectOutput(hdmiOut1)
            selectDSP(passTrough)
            setVolume(-20.0)
        }
    }
}

class RemoteControl {

    fun turnOnAV() {}
    fun selectInput(hdmiIn: Int) {}
    fun selectOutput(hdmiOut: Int) {}
    fun selectDSP(passTrough: Int) {}
    fun setVolume(value: Double) {}
}
