package de.ostfale.kotlin.collections.map

import de.ostfale.kotlin.classes.data.Recipe
import org.slf4j.LoggerFactory

class BasicMaps {

    private val log = LoggerFactory.getLogger(javaClass)

    private val r1 = Recipe("Chicken Soup", false)
    private val r2 = Recipe("Salad", true)
    private val r3 = Recipe("Thai Curry", false)
    private val recipeMap = mapOf("recipe1" to r1, "recipe2" to r2, "recipe3" to r3)

    fun containsAKey() {
        log.info("Does the map contain the key 'recipe1' : ${recipeMap.containsKey("recipe1")}")
    }

    fun containsAValue() {
        log.info("Does the map contain the value 'Salad' : ${recipeMap.containsValue(r2)}")
    }

    fun getAValue() {
        log.info("getValue for key 'recipe2' : ${recipeMap.getValue("recipe2")}") // returns null if not there
        log.info("get value for key 'recipe2' : ${recipeMap.get("recipe2")}") // throws exception if not there
        log.info("Indexing value for key 'recipe2' : ${recipeMap["recipe2"]}")
    }

    fun loopingThroughMap() {
        for ((key, value) in recipeMap) {
            log.info("Key : $key and value: $value")
        }
    }
}

fun main() {
    val myBasicMap = BasicMaps()
    myBasicMap.containsAKey()
    myBasicMap.containsAValue()
    myBasicMap.getAValue()
    myBasicMap.loopingThroughMap()
}