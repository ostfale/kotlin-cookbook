package de.ostfale.kotlin.functional.hiorfu

/**
 * Example data class to be used by built-in higher order functions for collections
 * Created :  08.08.2019
 *
 *  @author : Uwe Sauerbrei
 */
data class Grocery(val name: String, val category: String, val unit: String, val unitPrice: Double, val quantity: Int)

fun main() {
    val groceries = GroceryList().groceries

    val highestPrice = groceries.maxByOrNull { it.unitPrice }
    val minQuantity = groceries.minByOrNull { it.quantity }
    val sumQuantity = groceries.sumOf { it.quantity }
    val totalPrice = groceries.sumOf { it.quantity * it.unitPrice }

    println("The grocery with the highest price is: ${highestPrice?.name}")
    println("The grocery with the min quantity is: ${minQuantity?.name}")
    println("The sum of all grocery  quantity is: $sumQuantity")
    println("The total price of all grocery is: $totalPrice")
}
