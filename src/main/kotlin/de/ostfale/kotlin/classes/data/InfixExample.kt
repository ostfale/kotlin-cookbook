package de.ostfale.kotlin.classes.data

data class User(val id: Int, val name: String)

class Task(val id: Int, val title: String, var assignedUser: User? = null) {
    infix fun assignTo(user: User) {
        assignedUser = user
    }
}

fun main() {
    val user = User(10, "John Doe")
    val task = Task(567, "Fix bug in the production")

    task assignTo user

    println("'${task.title}' assigned to ${task.assignedUser?.name}") // 'Fix bug in the production' assigned to John Doe
}