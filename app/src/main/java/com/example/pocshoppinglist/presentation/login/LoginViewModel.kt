package com.example.pocshoppinglist.presentation.login

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pocshoppinglist.common.util.Resource
import com.example.pocshoppinglist.domain.model.User
import com.example.pocshoppinglist.domain.repository.LoginRepository
import com.example.pocshoppinglist.presentation.navigation.Navigator
import com.example.pocshoppinglist.presentation.navigation.Screen
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val repository: LoginRepository
) : ViewModel() {

    var state by mutableStateOf(LoginState())
        private set

    fun onEvent(event: LoginEvent) {
        when (event) {
            is LoginEvent.OnUsernameChange -> {
                state = state.copy(username = event.username)
            }
            is LoginEvent.OnEmailChange -> {
                state = state.copy(email = event.email)
            }
            is LoginEvent.OnPasswordChange -> {
                state = state.copy(password = event.password)
            }
            is LoginEvent.OnLoginAttempt -> {
                doLoginAttempt()
            }
        }
    }

    private fun doLoginAttempt() = viewModelScope.launch {
        when (val loginResponse =
            repository.login(User(state.username, state.email, state.password))) {
            is Resource.Success -> {
                validateLogin(loginResponse.data)
                if(state.successfulLogin) {
                    Navigator.navigateTo(Screen.ProductListScreen)
                }
            }
            else -> {
                TODO("some toast")
            }
        }
    }

    private fun validateLogin(token: String?) {
        state = if (token.isNullOrBlank()) {
            state.copy(
                successfulLogin = false,
                password = "",
                errorMessage = "Invalid credentials"
            )
        } else {
            state.copy(
                successfulLogin = true,
                errorMessage = ""
            )
        }
    }
}