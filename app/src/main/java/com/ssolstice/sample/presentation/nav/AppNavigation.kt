package com.ssolstice.sample.presentation.nav

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ssolstice.sample.presentation.main.MainScreen
import com.ssolstice.sample.presentation.theme.ThemeSettingsScreen

@Composable
fun AppNavGraph(startDestination: String = Screen.Home.route) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = startDestination) {
        composable(Screen.Home.route) {
            MainScreen(navController)
        }
        composable(Screen.ThemeSettings.route) {
            ThemeSettingsScreen()
        }
    }
}
