package de.ostfale.kotlin.core

import de.ostfale.kotlin.classes.inheritence.Wolf
import org.slf4j.LoggerFactory

class SafeCalls {

    private val log = LoggerFactory.getLogger(javaClass)

    var w: Wolf? = Wolf()           // question mark signals it is nullable
    var x = w?.hunger               // safe assign value (if w == null then x == null)

    // does not compile since the compiler can't guarantee no changes between check and us of the variable
    fun checkOldWay() {
        if (w != null) {
            //        w.eat()
        }
    }

    fun checkUsingLet() {
        w?.let {
            log.info("Check using let and it: {} ", it.eat())
        }
    }

    fun letWithArrays() {
        val array = arrayOf("Hi", "Hello", null)
        for (item in array) {
            item?.let {
                println(it)
            }
        }
    }

    fun checkForNull() {
        w?.eat()  // eat is only called if w != null
        w?.hunger = 6  // assign values to save cals

        log.info("Hunger : $x")
    }

    fun streamLineWithLet() {
        log.info("Streamline with let: {}", w?.getAlphaWolf()?.let { it.eat() })
    }

    fun elvisOperator() {
        log.info("Using Elvis operator: ${w?.hunger ?: -1}")
    }
}

fun main() {
    SafeCalls().apply {
        checkForNull()
        checkUsingLet()
        letWithArrays()
        streamLineWithLet()
        elvisOperator()
    }
}