package de.ostfale.kotlin.io

import java.nio.file.Paths

fun main() {
    listDirectory()
}

fun listDirectory() {
    val p = Paths.get(home, "Downloads")
    for (f in p.toFile().walk())
        println("Downloads content: ${f.name}")
}

