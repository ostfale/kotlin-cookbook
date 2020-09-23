package de.ostfale.kotlin.classes.functions

data class Car(val color: String, val model: String, val year: Int)

fun printColors(vararg cars: Car) {
    for (car in cars) {
        println(car.color)
    }
}

fun spreadOperator() {
    val manyCars = arrayOf(car1, car2, car3)
    printColors(*manyCars)
}

val car1 = Car("blue", "VW", 2018)
val car2 = Car("red", "BMW", 2017)
val car3 = Car("black", "Audi", 2019)

fun main() {
    printColors(car1, car2, car3)
    spreadOperator()
    val nums = arrayOf(1, 2, 3, 4) // use of varargs in lib
}