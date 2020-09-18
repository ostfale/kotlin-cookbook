package de.ostfale.kotlin.collections.list

import org.slf4j.LoggerFactory

class BasicLists {

    private val log = LoggerFactory.getLogger(javaClass)

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
    myListClass.printListItems(shoppingList)
    myListClass.findObjectInList(listWithType)
}


