package com.ihebchiha.domain.entity

import com.example.enum.UserRole
import com.ihebchiha.enum.Gender
import org.ktorm.entity.Entity

interface User: Entity<User> {
    companion object : Entity.Factory<User>()
    val id: Long
    var cin: String
    var firstname: String
    var lastname: String
    var address: String
    var gender: Gender
    var phone: String
    var email: String
    var passportNumber: String
    var birthdate: String
    var username: String
    var password: String
    var role: UserRole
    var hasAccount: Boolean
}