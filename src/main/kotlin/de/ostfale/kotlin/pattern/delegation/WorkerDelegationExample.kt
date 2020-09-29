package de.ostfale.kotlin.pattern.delegation

interface Worker {
    fun work()
    fun takeVacation()
    fun fillTimeSheet() = println("Why, really??")
}

interface Assistant {
    fun doChores()
    fun fillTimeSheet() = println("No escape from that...")
}

fun main() {
    val doe = Manager(CSharpDeveloper(), DepartmentAssistant())
    val roe = Manager(JavaDeveloper(), DepartmentAssistant())
    doe.work()
    doe.meeting()
    doe.takeVacation()  // executed on manager instance
    doe.doChores()
    doe.fillTimeSheet() // manually forwarded to Assistant

    roe.work()
    roe.meeting()
}

class Manager(
    private val staff: Worker,
    private val assistant: Assistant
) : Worker by staff, Assistant by assistant {

    override fun takeVacation() = println("Of course...")
    fun meeting() = println("Organizing meeting with ${staff.javaClass.simpleName}")

    override fun fillTimeSheet() {
        println("Manually forwarding this...")
        assistant.fillTimeSheet()
    }
}

class DepartmentAssistant : Assistant {
    override fun doChores() = println("Do routine stuff...")

}

class JavaDeveloper : Worker {
    override fun work() = println("Writing java code...")
    override fun takeVacation() = println("Coding at the beach..")
}

class CSharpDeveloper : Worker {
    override fun work() = println("Writing C# code...")
    override fun takeVacation() = println("Coding on the rocks...")
}