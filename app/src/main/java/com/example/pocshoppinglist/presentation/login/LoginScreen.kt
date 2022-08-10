package com.example.pocshoppinglist.presentation.login

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.pocshoppinglist.R

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
        TextField(
            value = state.username,
            placeholder = { Text(text = stringResource(id = R.string.username_placeholder)) },
            singleLine = true,
            onValueChange = { viewModel.onEvent(LoginEvent.OnUsernameChange(it)) })
        Spacer(modifier = Modifier.height(20.dp))
        TextField(
            value = state.email,
            placeholder = { Text(text = stringResource(id = R.string.email_placeholder)) },
            singleLine = true,
            onValueChange = { viewModel.onEvent(LoginEvent.OnEmailChange(it)) })
        Spacer(modifier = Modifier.height(20.dp))
        TextField(
            value = state.password,
            placeholder = { Text(text = stringResource(id = R.string.password_placeholder)) },
            singleLine = true,
            onValueChange = { viewModel.onEvent(LoginEvent.OnPasswordChange(it)) },
            visualTransformation = PasswordVisualTransformation()
        )
        Spacer(modifier = Modifier.height(15.dp))
        Button(onClick = { viewModel.onEvent(LoginEvent.OnLoginAttempt) }) {
            Text(text = stringResource(id = R.string.login_button))
        }
        if (state.errorMessage.isNotBlank()) {
            Text(
                text = state.errorMessage,
                color = MaterialTheme.colors.error
            )
        }
    }
}