package de.ostfale.kotlin.io

import java.io.File
import java.nio.file.Files
import java.nio.file.Paths
import java.nio.file.StandardCopyOption

fun main() {
    val p = Paths.get(home, "xx-dir", "subDir")
    val f1 = p.resolve("file1.tmp")
    val f2 = p.resolve("file2.tmp")
    try {
        Files.createDirectories(p)
        File(f1.toString()).writeText("Line1\nLine2")
        Files.copy(f1, f2, StandardCopyOption.REPLACE_EXISTING)
        Files.delete(f1)
        Files.delete(f2)
        Files.delete(p)
        Files.delete(p.parent)
    } catch (e: Exception) {
        println("Error: ${e.message}")
    }
}