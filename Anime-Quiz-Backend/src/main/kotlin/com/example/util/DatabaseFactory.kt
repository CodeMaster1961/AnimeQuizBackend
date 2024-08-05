package com.example.util

import com.example.entity.*
import com.typesafe.config.*
import kotlinx.coroutines.*
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.*
import org.jetbrains.exposed.sql.transactions.experimental.*

object DatabaseFactory {

    fun init() {
        val config: Config = ConfigFactory.load()
        val database = Database.connect(
            url = config.getString("ktor.database.url"),
            driver = config.getString("ktor.database.driver"),
            user = config.getString("ktor.database.user"),
            password = config.getString("ktor.database.password")
        )
        transaction(database) {
            SchemaUtils.create(QuestionEntity)
        }
    }

    suspend fun <T> databaseQuery(block: suspend () -> T): T =
        newSuspendedTransaction(Dispatchers.IO) { block() }
}