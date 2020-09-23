package de.ostfale.kotlin.core

import java.io.File
import java.io.FileNotFoundException
import java.net.URL

class ResourceReader {

    fun readFileFromResources(fileName: String): File {
        val resource: URL? = this::class.java.classLoader.getResource(fileName)
        if (resource != null) {
            return File(resource.toURI())
        }
        throw FileNotFoundException("File: $fileName could not be found!")
    }
}