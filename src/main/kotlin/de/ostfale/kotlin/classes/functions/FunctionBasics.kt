package de.ostfale.kotlin.classes.functions

fun main() {
    println(labelMultiply(3, 4, "The result is: "))
    println(labelMultiply(label = "The result with named args is: ", op2 = 3, op1 = 4))

    println(labelMultiplyOneLine(4, 5, "The one line result is: "))
    println(defaultLabel(4, 6))

    val emp = Employee("Jana")
    println(emp.upperCaseFirstName())
}

fun labelMultiply(op1: Int, op2: Int, label: String): String {
    return ("$label ${op1 * op2}")
}

fun labelMultiplyOneLine(op1: Int, op2: Int, label: String) = "$label ${op1 * op2}"

fun defaultLabel(op1: Int, op2: Int, label: String = "The answer is: ") = "$label ${op1 * op2}"

class Employee(private val firstName: String) {

    @OptIn(ExperimentalStdlibApi::class)
    fun upperCaseFirstName(): String {
        return firstName.uppercase()
    }
}
