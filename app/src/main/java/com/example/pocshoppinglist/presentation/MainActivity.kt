package com.example.pocshoppinglist.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.pocshoppinglist.presentation.login.LoginScreen
import com.example.pocshoppinglist.presentation.ui.theme.PocShoppingListTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PocShoppingListTheme {
                LoginScreen()
            }
        }
    }
}
