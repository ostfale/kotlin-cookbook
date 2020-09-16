package de.ostfale.kotlin.classes.data

data class Recipe(val title: String, val isVegetarian: Boolean)

data class RecipeDefault(
    val title: String,
    val mainIngredient: String,
    val isVegetarian: Boolean = false,
    val difficulty: String = "EASY"
) {
    fun findRecipes(
        title: String = "",
        mainIngredient: String = "",
        isVegetarian: Boolean = false,
        difficulty: String = ""
    ): RecipeDefault {
        return RecipeDefault("Thai Curry", "Curry")
    }
}

fun main() {
    val r1 = Recipe("Chicken", false)
    val r2 = Recipe("Chicken", false)

    standardFunctions(r1, r2)
    copyFunction(r1)
    destructuring(r1)
    destructuringToValues(r2)

    val rd = RecipeDefault("Beef", "Bread")
    val namedArgObj = RecipeDefault(mainIngredient = "Beef", title = "Spaghetti Bolognese")
    println("Data class with defaults: $rd")
    println("Data class with named args: $namedArgObj")
    println("Find Recipe with default params: ${rd.findRecipes()}")
}

private fun standardFunctions(r1: Recipe, r2: Recipe) {
    println("Are both recipes equal: ${r1 == r2}")
    println("Use both recipes the same underlying object: ${r1 === r2}")
    println("Hashcode r1 : ${r1.hashCode()} compared with hashcode of r2: ${r2.hashCode()} is equal!")
    println("ToString methods prints automatically parameter: $r1")
}

private fun copyFunction(r1: Recipe) {
    val rCopy = r1.copy(isVegetarian = true)
    println("Copied recipe with changed attribute: $rCopy")
}

private fun destructuring(r1: Recipe) {
    val title = r1.component1()
    println("Get first property: $title")
}

private fun destructuringToValues(r1: Recipe) {
    val (title, isVegetarian) = r1
    println("Get title: $title and vegetarian: $isVegetarian")
}