package com.ticonsys.kotlinretrofit.model

data  class LoginResponse(
    val message: String,
    val status: Int,
    val userData: UserData
)

data class UserData(
    val eid: String,
    val email: String,
    val id: String,
    val last_login: String,
    val password: String,
    val registration_date: String,
    val status: String,
    val user_level: String,
    val username: String
)