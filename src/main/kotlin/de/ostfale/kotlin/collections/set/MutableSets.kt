package de.ostfale.kotlin.collections.set

import org.slf4j.LoggerFactory

/**
 * Examples for mutable sets
 * Created :  28.07.2019
 *
 *  @author : Uwe Sauerbrei
 */
class MutableSets {

    private val log = LoggerFactory.getLogger(javaClass)

    private val myFriendSet = mutableSetOf("Jim", "Sue")

    fun addElementToSet() {
        log.info("Print set before adding element: $myFriendSet")
        myFriendSet.add("Tom")
        log.info("Print set after adding element Tom: $myFriendSet")
        myFriendSet.remove("Tom")
        log.info("Print set after removing element Tom: $myFriendSet")
    }

    fun addMultipleElementsToSet() {
        val toAdd = setOf("Mia", "Jane")
        log.info("Print set before adding multiple element: $myFriendSet")
        myFriendSet.addAll(toAdd)
        log.info("Print set after adding multiple element: $myFriendSet")
    }

    fun copyMutableSet() {
        val myFriendSetCopy = myFriendSet.toSet()
        log.info("Print copy of set: $myFriendSetCopy")
    }
}

fun main() {
    val myMutableSet = MutableSets()
    myMutableSet.addElementToSet()
    myMutableSet.addMultipleElementsToSet()
    myMutableSet.copyMutableSet()
}