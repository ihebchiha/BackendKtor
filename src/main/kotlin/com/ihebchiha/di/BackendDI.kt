package com.ihebchiha.di

import com.ihebchiha.repository.UserRepository
import com.ihebchiha.service.UserService
import com.ihebchiha.service.impl.UserServiceImpl
import org.kodein.di.DI
import org.kodein.di.bindSingleton
import org.ktorm.database.Database
import org.ktorm.logging.ConsoleLogger
import org.ktorm.logging.LogLevel

val kodein =  DI {
    bindSingleton {configureSQLServer()}
    bindSingleton { UserRepository() }
    bindSingleton<UserService> { UserServiceImpl() }
}

fun configureSQLServer() : Database{
    return Database.connect(url = "jdbc:sqlserver://localhost:1433",
        driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver",
        user = "sa", password = "DaTaBaSePaSSw0rd",
        logger = ConsoleLogger(threshold = LogLevel.INFO))
}