package de.ostfale.kotlin.io

import java.io.File
import java.nio.file.Paths

fun main() {
    writeToFile()
}

fun writeToFile() {
    val home = System.getProperty("user.home")
    val download = Paths.get(home, "Downloads")
    val f = File("$download/tmp.txt")
    f.writeText("This is a simple text...")
    f.appendText("\nSecond line appended")
    println("Read text from file: ${f.absolutePath} with content: ${f.readText()}")
    f.delete()
}
