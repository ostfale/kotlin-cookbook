package de.ostfale.kotlin.errors.exception

import java.nio.file.Files
import java.nio.file.Paths
import java.nio.file.StandardOpenOption

fun inputDouble(msg: String): Double {
    println("$msg ")
    val inp = readLine()  // String?
    return inp!!.toDouble()
}

fun main() {
    tryCatchUseEx()
    tryCatchEx()
    runCatchingEx()
}

fun runCatchingEx() {
    TODO("Not yet implemented")
}

fun tryCatchUseEx() {
    val currentDir = System.getProperty("user.dir")
    val tmpFile = Paths.get(currentDir, "tmp-file-kotlin.txt")
    println("TempFile: $tmpFile")
    try {
        val bw = Files.newBufferedWriter(tmpFile, StandardOpenOption.CREATE)
        bw.use {
            it.write("Line 1 \n")
            it.write("Line 2 \n")
        }
    } catch (e: Exception) {
        println("Error: $e")
    }
}

fun tryCatchEx() {
    try {
        val length = inputDouble("Länge:")
        val width = inputDouble("Width: ")
        println("Area: ${length * width}")
    } catch (e: Exception) {
        println("Error: $e")
        e.printStackTrace()
    }
}
