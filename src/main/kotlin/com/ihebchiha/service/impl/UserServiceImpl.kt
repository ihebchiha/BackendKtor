package com.ihebchiha.service.impl

import com.example.networking.request.LoginRequest
import com.example.networking.request.RegistrationRequest
import com.ihebchiha.di.kodein
import com.ihebchiha.dto.UserDto
import com.ihebchiha.networking.response.Token
import com.ihebchiha.repository.UserRepository
import com.ihebchiha.security.TokenGenerator
import com.ihebchiha.service.UserService
import org.kodein.di.instance
import org.mindrot.jbcrypt.BCrypt
import java.util.*

class UserServiceImpl(): UserService {

    private val userRepository: UserRepository by kodein.instance()

    override fun register(registrationRequest: RegistrationRequest): Int {
        return userRepository.save(registrationRequest)
    }

    override fun getUserByUsername(username: String) = userRepository.findUserByUsername(username)

    override fun getUserByEmail(email: String) = userRepository.findUserByEmail(email)

    override fun authenticate(loginRequest: LoginRequest) : Token{
        var token: Token? = null
        val user : UserDto = userRepository.findUserByUsername(loginRequest.username)
        user.apply {
            if (BCrypt.checkpw(loginRequest.password, user.password)){
                token = TokenGenerator.makeToken(user)
            }
        }
        return token!!
    }

}