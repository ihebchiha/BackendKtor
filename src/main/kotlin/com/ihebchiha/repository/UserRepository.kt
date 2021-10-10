package com.ihebchiha.repository

import com.ihebchiha.di.kodein
import com.ihebchiha.domain.Users
import com.ihebchiha.dto.UserDto
import com.ihebchiha.dto.toUserDto
import org.kodein.di.instance
import org.ktorm.database.Database
import org.ktorm.dsl.*


class UserRepository {
    private val db by kodein.instance<Database>()

    fun findUserByCin(cin: String) =
        db
            .from(Users)
            .select(Users.columns)
            .where {
                (Users.cin eq cin)
            }.map { row ->
                toUserDto(row)
            }.first()

    fun findUserByEmail(email: String) = db
        .from(Users)
        .select(Users.columns)
        .where {
            (Users.email eq email)
        }.map { row ->
            toUserDto(row)
        }.first()

}

