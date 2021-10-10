package com.ihebchiha.service.impl

import com.example.networking.request.RegistrationRequest
import com.ihebchiha.domain.Users
import com.ihebchiha.domain.entity.User
import com.ihebchiha.service.UserService
import com.ihebchiha.repository.UserRepository
import io.ktor.auth.*

class UserServiceImpl(private val userRepository: UserRepository): UserService {

    override fun register(registrationRequest: RegistrationRequest) {
       // return userRepository.save(registrationRequest).toUserModel()
    }
    override fun getUserByLoginCreds(userPasswordCredential: UserPasswordCredential) {
       // return userRepository.getUserByUsernameAndPassword(userPasswordCredential)
    }

    override fun getUserByCin(cin: String) = userRepository.findUserByCin(cin)

    override fun getUserByEmail(email: String) = userRepository.findUserByEmail(email)

}