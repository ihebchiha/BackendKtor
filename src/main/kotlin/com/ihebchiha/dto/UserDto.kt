package com.ihebchiha.dto

import com.ihebchiha.domain.Users
import org.ktorm.dsl.QueryRowSet

data class UserDto(
    var cin: String,
    var firstname: String,
    var lastname: String,
    var address: String,
    var gender: String,
    var phone: String,
    var email: String,
    var passportNumber: String,
    var birthdate: String,
    var username: String,
    var password: String,
    var role: String,
    var hasAccount: Boolean
)

fun toUserDto(row: QueryRowSet): UserDto =
    UserDto(
        row[Users.cin]!!,
        row[Users.firstName]!!,
        row[Users.lastName]!!,
        row[Users.address]!!,
        row[Users.gender]!!,
        row[Users.phone]!!,
        row[Users.email]!!,
        row[Users.passportNumber]!!,
        row[Users.birthdate]!!,
        row[Users.username]!!,
        row[Users.password]!!,
        row[Users.role]!!,
        row[Users.hasAccount]!!
    )
