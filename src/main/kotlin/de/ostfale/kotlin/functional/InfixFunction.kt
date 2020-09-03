package de.ostfale.kotlin.functional

import org.slf4j.LoggerFactory

/**
 * An infix function is a function that can be invoked via infix notation. It is a special type of function and has
 * specific rules to satisfy. One of the most common infix function is the to function to create a Pair object.
 * It can be invoked in this way <br>
 *     <ul>
 *         <li>https://medium.com/tompee/idiomatic-kotlin-infix-functions-eea833f70c90</li>
 *     </ul>
 *     <ol>
 *         <li>Must be a member function or extension function</li>
 *         <li>Must have a single parameter</li>
 *         <li>Parameter is not <code>vararg</code> and has not default value</li>
 *     </ol>
 */

fun main() {
    FunctionWithInfix() bark 6
    Warrior().attackTest()
}

class FunctionWithInfix {

    infix fun bark(x: Int) {
        for (i in 1..x) {
            println("Wuff!")
        }
    }
}

class Warrior(var hitPoints: Int = 0, var attackPoints: Int = 0) {

    private val log = LoggerFactory.getLogger(javaClass)

    private infix fun attack(anotherWarrior: Warrior) {
        anotherWarrior.hitPoints -= attackPoints
    }

    fun attackTest() {
        val warrior1 = Warrior(100, 20)
        val warrior2 = Warrior(100, 15)

        warrior1 attack warrior2
        log.info("Warrior 2 HitPoints: ${warrior2.hitPoints}")
    }
}

