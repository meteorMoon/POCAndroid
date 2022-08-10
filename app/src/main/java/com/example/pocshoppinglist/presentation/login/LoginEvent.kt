package com.example.pocshoppinglist.presentation.login

sealed class LoginEvent {
    object OnLoginAttempt : LoginEvent()
    class OnUsernameChange(val username: String) : LoginEvent()
    class OnEmailChange(val email: String) : LoginEvent()
    class OnPasswordChange(val password: String) : LoginEvent()
}
