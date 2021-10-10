package com.ihebchiha.plugins

import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import org.flywaydb.core.Flyway
import org.ktorm.database.Database
import javax.sql.DataSource

fun configureDatasource() {
    val pool = hikariForDev()
//    Database.connect(url = "jdbc:sqlserver://localhost:1433",
//        driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver",
//        user = "sa", password = "DaTaBaSePaSSw0rd",
//        logger = ConsoleLogger(threshold = LogLevel.INFO)
//    )
    Database.connect(pool)
    //runFlyway(pool)
}
private fun hikariForDev(): HikariDataSource {
    val config = HikariConfig()
    config.driverClassName = "org.h2.Driver"
    config.jdbcUrl = "jdbc:h2:mem:test"
    config.maximumPoolSize = 3
    config.isAutoCommit = false
    config.transactionIsolation = "TRANSACTION_REPEATABLE_READ"
    config.validate()
    return HikariDataSource(config)
}

private fun hikari(): HikariDataSource {
    val config = HikariConfig().apply {
        driverClassName = "com.microsoft.sqlserver.jdbc.SQLServerDriver"
        jdbcUrl = "jdbc:sqlserver://localhost:1433;database=db_test;username=sa;password=DaTaBaSePaSSw0rd;"
        maximumPoolSize = 3
        isAutoCommit = false
        transactionIsolation = "TRANSACTION_REPEATABLE_READ"
        validate()
    }
    return HikariDataSource(config)
}

private fun runFlyway(datasource: DataSource) {
    val flyway = Flyway.configure()
        .dataSource(datasource)
        .load()
    try {
        flyway.info()
        flyway.migrate()
    } catch (e: Exception) {
        throw e
    }
}