package de.ostfale.kotlin.classes.inheritance

sealed class DownloadState
object NotYetStarted : DownloadState()
class Error(val errMsg: String) : DownloadState()
class Downloading(val progress: Int) : DownloadState()
class Done(val result: String) : DownloadState()

fun showStatus(state: DownloadState) {
    val msg: String = when (state) {
        is NotYetStarted -> "Not started yet"
        is Error -> "Error: ${state.errMsg}"
        is Downloading -> "Running with ${state.progress} % progress"
        is Done -> "Finished. Amount of data: ${state.result} }}"
    }
    println("State: $msg")
}

fun main() {
    val state = Downloading(66)
    showStatus(state)
}