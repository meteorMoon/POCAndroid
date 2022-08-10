package com.example.pocshoppinglist.presentation.navigation

sealed class Screen(val route: String) {
    object LoginScreen: Screen("login_screen")
    object ProductListScreen: Screen("product_list_screen")
}
