package com.ihebchiha.di

import org.kodein.di.DI
import org.kodein.di.bindSingleton
import org.ktorm.database.Database
import org.ktorm.logging.ConsoleLogger
import org.ktorm.logging.LogLevel

val kodein =  DI {
    bindSingleton {configureSQLServer()}
}

fun configureSQLServer() : Database{
    return Database.connect(url = "jdbc:sqlserver://localhost:1433",
        driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver",
        user = "sa", password = "DaTaBaSePaSSw0rd",
        logger = ConsoleLogger(threshold = LogLevel.INFO))
}