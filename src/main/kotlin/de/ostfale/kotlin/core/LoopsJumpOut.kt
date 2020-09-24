package de.ostfale.kotlin.core

import org.slf4j.LoggerFactory

class LoopsJumpOut {

    private val log = LoggerFactory.getLogger(javaClass)

    fun myFun() {
        listOf("A", "B", "C", "D", "E").forEach myLoop@{
            if (it == "C") return@myLoop
            log.info(it)
        }
        log.info("Finished myFun function....")
    }

    fun myFunImplicit() {
        listOf("A", "B", "C", "D", "E").forEach {
            if (it == "A") return@forEach
            log.info(it)
        }
        log.info("Finished myFun implicit function....")
    }

}

fun main() {
    LoopsJumpOut().apply {
        myFun()
        myFunImplicit()
    }
}