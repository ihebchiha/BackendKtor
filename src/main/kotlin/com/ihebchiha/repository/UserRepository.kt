package com.ihebchiha.repository


import com.example.networking.request.RegistrationRequest
import com.ihebchiha.di.kodein
import com.ihebchiha.domain.Users
import com.ihebchiha.dto.toUserDto
import org.kodein.di.instance
import org.ktorm.database.Database
import org.ktorm.dsl.*
import org.mindrot.jbcrypt.BCrypt


class UserRepository {
    private val db by kodein.instance<Database>()

    fun findUserByUsername(username: String) =
        db
            .from(Users)
            .select(Users.columns)
            .where {
                (Users.cin eq username)
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


    fun save(registrationRequest: RegistrationRequest): Int {
        return db.insert(Users) {
            set(it.email, registrationRequest.email)
            set(it.username, registrationRequest.username)
            set(it.password, BCrypt.hashpw(registrationRequest.password, BCrypt.gensalt()))
        }
    }
}

