package com.ihebchiha.domain

import com.example.enum.UserRole
import com.ihebchiha.domain.entity.User
import com.ihebchiha.enum.Gender
import org.ktorm.schema.Column
import org.ktorm.schema.Table
import org.ktorm.schema.boolean
import org.ktorm.schema.varchar

object Users : Table<User>("01_user") {
    val id: Column<String> = varchar("id").primaryKey()
    val cin: Column<String> = varchar("cin")
    val gender: Column<String> = varchar("gender")
    val firstName: Column<String> = varchar("first_name")
    val lastName: Column<String> = varchar("last_name")
    val address: Column<String> = varchar("address")
    val phone: Column<String> = varchar("phone")
    val email: Column<String> = varchar("email")
    val passportNumber: Column<String> = varchar("passport_number")
    val username: Column<String> = varchar("username")
    val password: Column<String> = varchar("password")
    val birthdate: Column<String> = varchar("birthdate")
    val role: Column<String> = varchar("role")
    val hasAccount: Column<Boolean> = boolean("hasAccount")
}