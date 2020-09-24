package de.ostfale.kotlin.functional.hiorfu

/**
 * Provides a list of groceries
 * Created :  12.08.2019
 *
 *  @author : Uwe Sauerbrei
 */
open class GroceryList {

    val groceries: List<Grocery> = listOf(
        Grocery("Tomatoes", "Vegetable", "lb", 3.0, 3),
        Grocery("Mushrooms", "Vegetable", "lb", 4.0, 1),
        Grocery("Bagels", "Bakery", "Pack", 1.5, 2),
        Grocery("Olive oil", "Pantry", "Bottle", 6.0, 1),
        Grocery("Ice cream", "Frozen", "Pack", 3.0, 2)
    )
}