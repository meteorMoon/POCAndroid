package com.example.pocshoppinglist.presentation.login

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun LoginScreen(
    viewModel: LoginViewModel = hiltViewModel()
) {

    val state = viewModel.state

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
    ) {
        TextField(value = state.username, onValueChange = {viewModel.onEvent(LoginEvent.OnUsernameChange(it))})
        Spacer(modifier = Modifier.height(20.dp))
        TextField(value = state.email, onValueChange = {viewModel.onEvent(LoginEvent.OnEmailChange(it))})
        Spacer(modifier = Modifier.height(20.dp))
        TextField(value = state.password, onValueChange = {viewModel.onEvent(LoginEvent.OnPasswordChange(it))})
        Spacer(modifier = Modifier.height(15.dp))
        Button(onClick = { viewModel.onEvent(LoginEvent.OnLoginAttempt) }) {

        }
    }
}