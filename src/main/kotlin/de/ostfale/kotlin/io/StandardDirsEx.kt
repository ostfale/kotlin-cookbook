package de.ostfale.kotlin.io

import java.nio.file.FileSystem
import java.nio.file.Files
import java.nio.file.Paths

fun main() {
    findStandardDirs()
    pathExample()
    createSubDirEx()
}

fun createSubDirEx() {
    val tmp = System.getProperty("java.io.tmpdir")
    val tmpPath = Paths.get(tmp)
    println("TmpDir : $tmp")
    val subDir = tmpPath.resolve("mySubDir")
    println("Sub dir resolved: $subDir")
    println("Does subdir exists: ${Files.exists(subDir)}")
}

fun pathExample() {
    val current = System.getProperty("user.dir")
    val currPath = Paths.get(current)
    println("Paths current: ${currPath.toRealPath()}")

    val home = System.getProperty("user.home")
    val download = Paths.get(home, "Downloads")
    println("Path 'added' : $download")
}

fun findStandardDirs() {
    val current = System.getProperty("user.dir")
    val home = System.getProperty("user.home")
    val tmp = System.getProperty("java.io.tmpdir")
    println("Show current path: $current")
    println("Show home path: $home")
    println("Show tmp path: $tmp")
}