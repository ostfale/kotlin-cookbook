package de.ostfale.kotlin.classes.enums

import org.slf4j.LoggerFactory

enum class Department(private val fullName: String, private val numEmployees: Int) {

    HR("Human Resources", 5),
    IT("Information Technology", 10),
    ACCOUNTING("Human Resources", 3),
    SALES("Sales team", 20);

    fun getDeptInfo() = "The $fullName department has $numEmployees employees!"
}

fun main() {
    val log = LoggerFactory.getLogger(Department::class.java)
    log.info("Show result for HR: ${Department.HR.getDeptInfo()}")
    log.info("Show result for IT: ${Department.IT.getDeptInfo()}")
    log.info("Show result for ACCOUNTING: ${Department.ACCOUNTING.getDeptInfo()}")
    log.info("Show result for SALES: ${Department.SALES.getDeptInfo()}")
}