package de.ostfale.kotlin.core

import org.slf4j.LoggerFactory

fun main() {
    NullReferences().apply {
        baseNull()
        nullAsPossibleArg()
    }
    simpleNullOperations()
}

fun simpleNullOperations() {
    val a: Int? = 3
    val b: Int? = null
    val c = a!! // c = Int
    println("c = $c")

    // elvis
    println(a ?: -1)
    println(b ?: -1)

    val d = b!! // exception
    println("d = $d")
}

class NullReferences {
    private val log = LoggerFactory.getLogger(javaClass)

    @OptIn(ExperimentalStdlibApi::class)
    fun baseNull() {
        val str: String? = "This isn't null"
        // str.uppercase() // not possible if it can be null

        if (str != null) {
            str.uppercase()
        }

        str?.lowercase()  // safe call operator

        val nullStr: String? = null
        log.info("What happens with nullStr.uppercase() : ${nullStr?.uppercase()}") // print 'null'
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



