package com.ssolstice.sample.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Typography
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import com.ssolstice.sample.data.model.ThemeMode

@Composable
fun AppThemeWrapper(
    themeMode: ThemeMode = ThemeMode.AUTO,
    content: @Composable () -> Unit
) {
    val isDark = when (themeMode) {
        ThemeMode.LIGHT -> false
        ThemeMode.DARK -> true
        ThemeMode.AUTO -> isSystemInDarkTheme()
    }
    MaterialTheme(
        colorScheme = if (isDark) darkColorScheme() else lightColorScheme(),
        typography = Typography(),
        content = content
    )
}