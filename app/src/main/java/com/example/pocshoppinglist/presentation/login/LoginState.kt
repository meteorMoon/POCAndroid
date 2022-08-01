package com.example.pocshoppinglist.presentation.login

data class LoginState(
    val username: String = "",
    val email: String = "",
    val password: String = "",
    val successfulLogin: Boolean = false,
    val errorMessage: String = ""
)
