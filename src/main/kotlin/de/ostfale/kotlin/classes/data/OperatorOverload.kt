package de.ostfale.kotlin.classes.data

data class Sprint(val todoTasks: Int, val doneTasks: Int) {
    operator fun plus(other: Sprint): Sprint {
        return Sprint(todoTasks + other.todoTasks, doneTasks + other.doneTasks)
    }
}

fun main() {
    val sprint1 = Sprint(51, 20)
    val sprint2 = Sprint(31, 40)

    val newSprint = sprint1 + sprint2
    println("New sprint todo: ${newSprint.todoTasks} and already done: ${newSprint.doneTasks}")
}