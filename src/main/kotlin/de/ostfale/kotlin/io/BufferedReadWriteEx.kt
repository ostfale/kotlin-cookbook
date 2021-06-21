package de.ostfale.kotlin.io

import java.io.BufferedWriter
import java.io.File
import java.nio.file.Paths

fun main() {
    buffWriteEx()
    fileAsTextEx()
    fileAsTextShortEx()
    buffReadEx()
}

fun fileAsTextShortEx() {
    val home = System.getProperty("user.home")
    val download = Paths.get(home, "Downloads")
    val f = File("$download/tmp.txt")
    val text = f.bufferedReader().use { it.readText() }
    println("Short version of text reader: $text")
}

fun fileAsTextEx() {
    val home = System.getProperty("user.home")
    val download = Paths.get(home, "Downloads")
    val f = File("$download/tmp.txt")
    val br = f.bufferedReader()
    val text = br.readText()
    println("All text read at once: $text")
    br.close()
}


fun buffReadEx() {
    val home = System.getProperty("user.home")
    val download = Paths.get(home, "Downloads")
    val f = File("$download/tmp.txt")
    //  f.bufferedReader().forEachLine { line ->
    f.forEachLine { line ->
        println(line)
    }
    f.delete()
}

fun BufferedWriter.writeLine(line: String) {
    write("$line\n")
}

// use closes the writer
fun buffWriteEx() {
    val home = System.getProperty("user.home")
    val download = Paths.get(home, "Downloads")
    val f = File("$download/tmp.txt")
    f.bufferedWriter().use { writer ->
        for (i in (1..10)) {
            writer.writeLine("Line $i")
        }
    }
}
