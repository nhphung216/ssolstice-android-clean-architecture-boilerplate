package com.ssolstice.sample.presentation.nav

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object ThemeSettings : Screen("theme_settings")
}