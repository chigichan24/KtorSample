package com.chigichan24

import com.chigichan24.controllers.roomController
import com.chigichan24.controllers.userController
import io.ktor.application.Application
import io.ktor.application.install
import io.ktor.features.CallLogging
import io.ktor.routing.Routing

/**
 * Created by chigichan24 on 2018/06/11.
 */

class Routers {
    fun Application.start() {
        install(CallLogging)
        install(Routing) {
            userController()
            roomController()
        }
    }
}