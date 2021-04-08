package de.ostfale.kotlin.collections.list

import org.slf4j.LoggerFactory

class BasicLists {

    private val log = LoggerFactory.getLogger(javaClass)

    fun simpleLists() {
        val lst1 = listOf(1, 2, 3)
        val lst2 = listOf(5, 6, 7, 8)
        val lst3 = lst1 + lst2 + lst1
        val lst4 = lst3 - lst1
        log.debug("Sum of lst1 + lst2 + lst1 =  $lst3")
        log.debug("Diff lst3 - lst1 = $lst4")
    }

    fun printListItems(shoppingList: List<String>) {
        if (shoppingList.isNotEmpty()) {
            log.info("List first item: ${shoppingList[0]}")
            log.info("List second item: ${shoppingList.get(1)}")
        }

        for (item in shoppingList) {
            log.info("Looped item: $item")
        }
    }

    fun findObjectInList(aList: List<String>) {
        if (aList.contains("Type")) {
            log.info("Index of Type in List: ${aList.indexOf("Type")}")
        }
    }
}

fun main() {
    // with type
    val listWithType: List<String> = listOf("List", "With", "Type")

    // compiler infers type
    val shoppingList = listOf("Tea", "Eggs", "Milk")

    val myListClass = BasicLists()
    myListClass.simpleLists()
    myListClass.printListItems(shoppingList)
    myListClass.findObjectInList(listWithType)
}


