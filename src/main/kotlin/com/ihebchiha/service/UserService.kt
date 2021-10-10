package com.ihebchiha.service

import com.example.networking.request.RegistrationRequest
import com.ihebchiha.domain.entity.User
import com.ihebchiha.dto.UserDto
import io.ktor.auth.*

interface UserService {

    fun register(registrationRequest: RegistrationRequest)

    fun getUserByCin(cin: String): UserDto
    fun getUserByEmail(cin: String): UserDto

    fun getUserByLoginCreds(userPasswordCredential: UserPasswordCredential)
}