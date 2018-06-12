package com.chigichan24.models

import org.jetbrains.exposed.dao.EntityID
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.sql.transactions.transaction
import com.chigichan24.dao.Users as UsersDao

/**
 * Created by chigichan24 on 2018/06/12.
 */

class User(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<User>(UsersDao)

    var name by UsersDao.name
    var email by UsersDao.email
    var age by UsersDao.age
}

class UserModel() {

    fun create(name: String, email: String, age: Int) = transaction {
        User.new {
            this.name = name
            this.email = email
            this.age = age
        }
    }

    fun find(id: Int): User? = transaction {
        User.findById(id)
    }

    fun update(id: Int, name: String? = null, email: String? = null, age: Int? = null) = transaction {
        val user = User.findById(id)
        name?.let { user?.name = name }
        email?.let { user?.email = email }
        age?.let { user?.age = age }
    }
}