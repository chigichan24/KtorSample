package com.chigichan24.controllers

import com.chigichan24.models.UserModel
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
    val userModel = UserModel()
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
        val result = userModel.find(id.id)
        call.respond("user name = ${result?.name}")
    }

    get<Users.Create> { create ->
        userModel.create(create.name, create.email, create.age)
        call.respond("created!")
    }

}

@Location("/users")
class Users {

    @Location("/create")
    data class Create(val name: String, val email: String, val age: Int)

    @Location("/search")
    data class Search(val id: Int, val name: String? = null)

    @Location("/{id}")
    data class Id(val id: Int)
}