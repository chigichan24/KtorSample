package com.chigichan24.controllers

import io.ktor.application.call
import io.ktor.response.respond
import io.ktor.routing.Route
import io.ktor.routing.get
import io.ktor.routing.route

/**
 * Created by chigichan24 on 2018/06/11.
 */

fun Route.roomController() {
    route("/room") {
        get {
            call.respond("room !~!!")
        }
    }
}