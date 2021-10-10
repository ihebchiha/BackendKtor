package com.ihebchiha

import com.ihebchiha.datasource.DatabaseFactory
import io.ktor.application.*
import com.ihebchiha.plugins.*

fun main(args: Array<String>): Unit =
    io.ktor.server.netty.EngineMain.main(args)

@Suppress("unused") // application.conf references the main function. This annotation prevents the IDE from marking it as unused.
fun Application.module() {
    //configureDatasource()
    DatabaseFactory.connectAndMigrate()
    configureRouting()
    configureSerialization()
    configureMonitoring()
    configureHTTP()
    configureSecurity()
}
