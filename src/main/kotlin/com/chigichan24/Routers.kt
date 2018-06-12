package com.chigichan24

import com.chigichan24.controllers.roomController
import com.chigichan24.controllers.userController
import com.chigichan24.dao.Users
import io.ktor.application.Application
import io.ktor.application.install
import io.ktor.features.CallLogging
import io.ktor.locations.Locations
import io.ktor.routing.Routing
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils.create
import org.jetbrains.exposed.sql.transactions.transaction

/**
 * Created by chigichan24 on 2018/06/11.
 */

class Routers {

    private fun initDb() {
        val db = Database.connect("jdbc:mysql://localhost:3306/chigichan24", driver = "com.mysql.jdbc.Driver", user = "root", password = "")
        transaction {
            create(Users)
        }
    }

    fun Application.install() {
        install(Locations)
        install(CallLogging)
        initDb()
        install(Routing) {
            userController()
            roomController()
        }
    }
}