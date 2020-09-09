package de.ostfale.kotlin.core

import org.slf4j.LoggerFactory

fun main() {
    NullReferences().apply {
        baseNull()
        nullAsPossibleArg()
    }
}

class NullReferences {
    private val log = LoggerFactory.getLogger(javaClass)

    fun baseNull() {
        val str: String? = "This isn't null"
        // str.toUpperCase() // not possible if it can be null

        if (str != null) {
            str.toUpperCase()
        }

        str?.toLowerCase()  // safe call operator

        val nullStr: String? = null
        log.info("What happens with nullStr.toUpperCase() : ${nullStr?.toUpperCase()}") // print 'null'
    }

    fun nullAsPossibleArg() {
        val str: String? = "This isn't null"
        str?.let { printText(str) }     // check for not being null with let
        printText(str!!)                // only if absolutely sure, it is NOT NULL
    }

    private fun printText(text: String) {
        log.info("Print: $text")
    }
}



