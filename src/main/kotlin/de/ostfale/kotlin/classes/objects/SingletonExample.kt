package de.ostfale.kotlin.classes.objects

import java.time.Year

object CompanyCommunications {
    private val currentYear = Year.now().value

    fun getTagLine() = "Our Company rocks!"
    fun getCopyRightLine() = "Copyright \u00A9 $currentYear. All rights reserved!"
}

fun main() {
    println(CompanyCommunications.getTagLine())
    println(CompanyCommunications.getCopyRightLine())
}