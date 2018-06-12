package com.chigichan24.dao

import org.jetbrains.exposed.dao.IntIdTable
import org.jetbrains.exposed.sql.Column

/**
 * Created by chigichan24 on 2018/06/11.
 */

object Users : IntIdTable() {
    val name: Column<String> = varchar("name", 255)
    val email: Column<String> = varchar("email", 255)
    val age: Column<Int> = integer("age")
}