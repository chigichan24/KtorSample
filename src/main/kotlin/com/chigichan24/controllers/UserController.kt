package com.chigichan24.controllers

import io.ktor.application.call
import io.ktor.locations.Location
import io.ktor.locations.get
import io.ktor.response.respond
import io.ktor.routing.Route
import io.ktor.routing.get
import io.ktor.routing.route

/**
 * Created by chigichan24 on 2018/06/11.
 */

fun Route.userController() {
    route("/hoge") {
        get {
            call.respond("hoge")
        }
    }

    route("/fuga") {
        get {
            call.respond("fuga")
        }
    }

    get<Users.Id> { id ->
        id.id
        call.respond("user id = ${id.id}")
    }

}

@Location("/users")
class Users {

    @Location("/search")
    data class Search(val id: Int, val name: String? = null)

    @Location("/{id}")
    data class Id(val id: Int)
}