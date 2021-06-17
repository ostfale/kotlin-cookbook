package de.ostfale.kotlin.io

import java.nio.file.Files
import java.nio.file.Paths
import kotlin.io.path.exists
import kotlin.io.path.isDirectory
import kotlin.io.path.isRegularFile

fun main() {
    existenceFileDir()
    checkProperties()
}

fun checkProperties() {
    val p = Paths.get(home, "Downloads")
    println("Is readable: ${Files.isReadable(p)}")
    println("Is writable: ${Files.isWritable(p)}")
    println("Is hidden: ${Files.isHidden(p)}")
    println("Is executable: ${Files.isExecutable(p)}")
    println("Its size: ${Files.size(p)}")
    println("Its last modified time: ${Files.getLastModifiedTime(p)}")
    println("Its owner: ${Files.getOwner(p)}")
}

val home: String = System.getProperty("user.home")

fun existenceFileDir() {
    val p = Paths.get(home, "Downloads")
    println("Does ${p.toRealPath()} exist: ${p.exists()}")
    println("Is it a directory: ${p.isDirectory()}")
    println("Is it a file: ${p.isRegularFile()}")
}
