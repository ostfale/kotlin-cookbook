package de.ostfale.kotlin.collections.list

import org.slf4j.LoggerFactory

class MutableLists {

    private val log = LoggerFactory.getLogger(javaClass)

    private val mShopping = mutableListOf("Tea", "Eggs")

    fun addElementToList(aVAl: String) {
        log.info("List before: $mShopping")
        mShopping.add(aVAl)
        log.info("List after: $mShopping")
    }

    fun copyElementList() {
        val toAdd = listOf("Cookies", "Sugar")
        mShopping.addAll(toAdd)
        log.info("List before copying:  $mShopping")
        val mShoppingCopy = mShopping.toList()
        log.info("List copy is immutable: $mShoppingCopy")
    }

    fun addAllElementsToList() {
        val toAdd = listOf("Cookies", "Sugar")
        log.info("List before adding all: $mShopping")
        mShopping.addAll(toAdd)
        log.info("List after adding all: $mShopping")
        mShopping.retainAll(listOf("Eggs", "Sugar"))
        log.info("List after retaining Eggs and Sugar: $mShopping")
        mShopping.clear()
        log.info("List after clearing: $mShopping")
    }

    fun removeElementToList(aVAl: String) {
        log.info("List before: $mShopping")
        mShopping.remove(aVAl)
        log.info("List after: $mShopping")
    }

    fun replaceElementToList(aVAl: String) {
        log.info("List before replace: $mShopping")
        mShopping[0] = aVAl
        log.info("List after replace: $mShopping")
    }

    fun sortAndShuffleElementsInList() {
        mShopping.add("Honey")
        mShopping.add("Bread")
        log.info("List before sort: $mShopping")
        mShopping.sort()
        log.info("List after sort: $mShopping")
        mShopping.shuffle()
        log.info("List after shuffle: $mShopping")
    }
}

fun main() {
    val myMList = MutableLists()
    myMList.addElementToList("Milk")
    myMList.copyElementList()
    myMList.removeElementToList("Milk")
    myMList.replaceElementToList("Coffee")
    myMList.sortAndShuffleElementsInList()
    myMList.addAllElementsToList()
}