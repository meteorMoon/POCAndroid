package com.example.pocshoppinglist.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.pocshoppinglist.presentation.login.LoginScreen
import com.example.pocshoppinglist.presentation.product_list.ProductListScreen
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@Composable
fun NavigationComponent(
    navController: NavHostController,
    navigator: Navigator
) {
    
    LaunchedEffect("navigation") {
        navigator.navChannelEvent.onEach {
            navController.navigate(it.route)
        }.launchIn(this)
    }
    
    NavHost(navController = navController, startDestination = Screen.LoginScreen.route) {
        composable(route = Screen.LoginScreen.route) {
            LoginScreen()
        }
        composable(route = Screen.ProductListScreen.route) {
            ProductListScreen()
        }
    }
}