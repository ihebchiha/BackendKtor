package com.ihebchiha.service

import com.example.networking.request.LoginRequest
import com.example.networking.request.RegistrationRequest
import com.ihebchiha.domain.entity.User
import com.ihebchiha.dto.UserDto
import com.ihebchiha.networking.response.Token
import io.ktor.auth.*

interface UserService {

    fun register(registrationRequest: RegistrationRequest): Int

    fun getUserByUsername(username: String): UserDto
    fun getUserByEmail(email: String): UserDto
    fun authenticate(loginRequest: LoginRequest): Token
}