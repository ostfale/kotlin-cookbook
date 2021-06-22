package de.ostfale.kotlin.database

import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.`java-time`.CurrentDateTime
import org.jetbrains.exposed.sql.`java-time`.datetime
import org.jetbrains.exposed.sql.transactions.transaction

object RunLogs : IntIdTable() {
    val status = varchar("status", 50)
    val ts = datetime("ts").defaultExpression(CurrentDateTime())
}

class RunLog(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<RunLog>(RunLogs)

    var status by RunLogs.status
    var ts by RunLogs.ts
}

fun main() {
    Database.connect("jdbc:sqlite:us.db", "org.sqlite.JDBC")

    transaction {
        addLogger(StdOutSqlLogger) // log to console
        SchemaUtils.create(RunLogs) // create table if not exists

        val newId = RunLogs.insert {
            it[status] = "started"
        }[RunLogs.id]
        println("Id of new dataset: $newId")

        val entries = RunLog.all().sortedBy { it.id }
        for (entry in entries) {
            println("ID=${entry.id} status=${entry.status} timestamp = ${entry.ts}")
        }
        Thread.sleep(500L)

        transaction {
            RunLogs.insert {
                it[status] = "ending"
            }
        }

    }
}