package com.example.pocshoppinglist.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.example.pocshoppinglist.presentation.navigation.NavigationComponent
import com.example.pocshoppinglist.presentation.navigation.Navigator
import com.example.pocshoppinglist.presentation.ui.theme.PocShoppingListTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PocShoppingListTheme {
                val navController = rememberNavController()
                NavigationComponent(navController = navController, navigator = Navigator)
            }
        }
    }
}
