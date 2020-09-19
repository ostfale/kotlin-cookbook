package de.ostfale.kotlin.collections.map

import de.ostfale.kotlin.classes.data.Recipe
import org.slf4j.LoggerFactory


class MutableMaps {

    private val log = LoggerFactory.getLogger(javaClass)

    private val r1 = Recipe("Chicken Soup", false)
    private val r2 = Recipe("Quinoa Salad", true)
    private val mRecipeMap = mutableMapOf("Recipe1" to r1, "Recipe2" to r2)

    fun addElementToMap() {
        val r3 = Recipe("Thai Curry", false)
        log.info("Print map before adding element: $mRecipeMap")
        mRecipeMap["Recipe3"] = r3
        log.info("Print map after adding element: $mRecipeMap")
    }

    fun addMultipleElementsToMap() {
        val r4 = Recipe("Jambalya", true)
        val r5 = Recipe("Sausage Rolls", false)
        val recipesToAdd = mapOf("Recipe4" to r4, "Recipe5" to r5)
        log.info("Print map before adding elements: $mRecipeMap")
        mRecipeMap.putAll(recipesToAdd)
        log.info("Print map after adding elements: $mRecipeMap")
    }

    fun removeElement() {
        log.info("Print map before removing 'Recipe2' : $mRecipeMap")
        mRecipeMap.remove("Recipe2")
        log.info("Print map after removing 'Recipe2' : $mRecipeMap")
    }

    fun makeCopyOfMap() {
        val recipeMapCopy = mRecipeMap.toMap()
        log.info("Copy of the original map: $recipeMapCopy")
        val recipeList = mRecipeMap.toList()
        log.info("List copy of the original map: $recipeList")

    }

    fun getEntriesAndValues() {
        val recipeEntries = mRecipeMap.entries
        val recipeValues = mRecipeMap.values
        val recipeKeys = mRecipeMap.keys
        log.info("Map entries: $recipeEntries")
        log.info("Map values: $recipeValues")
        log.info("Map keys: $recipeKeys")
        mRecipeMap.clear()
        log.info("Print map after clearing it : $mRecipeMap")
    }
}

fun main() {
    val myMutableMap = MutableMaps()
    myMutableMap.addElementToMap()
    myMutableMap.addMultipleElementsToMap()
    myMutableMap.removeElement()
    myMutableMap.makeCopyOfMap()
    myMutableMap.getEntriesAndValues()
}