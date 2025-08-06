package com.ssolstice.sample.data.local.preferences

import com.ssolstice.sample.data.model.ThemeMode
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class ThemePreferenceManager @Inject constructor(
    private val dataStore: DataStore<Preferences>
) {
    companion object {
        private val THEME_KEY = stringPreferencesKey("app_theme_mode")
    }

    val themeFlow: Flow<ThemeMode> = dataStore.data
        .map { preferences ->
            when (preferences[THEME_KEY] ?: "auto") {
                "light" -> ThemeMode.LIGHT
                "dark" -> ThemeMode.DARK
                else -> ThemeMode.AUTO
            }
        }

    suspend fun saveTheme(mode: ThemeMode) {
        dataStore.edit { preferences ->
            preferences[THEME_KEY] = mode.name.lowercase()
        }
    }
}

