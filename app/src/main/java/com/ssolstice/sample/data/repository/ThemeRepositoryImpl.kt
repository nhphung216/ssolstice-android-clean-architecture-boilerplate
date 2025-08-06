package com.ssolstice.sample.data.repository

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import com.ssolstice.sample.data.model.ThemeMode
import com.ssolstice.sample.domain.repository.ThemeRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class ThemeRepositoryImpl @Inject constructor(
    private val dataStore: DataStore<Preferences>
) : ThemeRepository {

    companion object {
        private val THEME_KEY = stringPreferencesKey("app_theme_mode")
    }

    override fun getThemeFlow(): Flow<ThemeMode> = dataStore.data.map { preferences ->
        when (preferences[THEME_KEY] ?: "auto") {
            "light" -> ThemeMode.LIGHT
            "dark" -> ThemeMode.DARK
            else -> ThemeMode.AUTO
        }
    }

    override suspend fun setThemeMode(mode: ThemeMode) {
        dataStore.edit { preferences ->
            preferences[THEME_KEY] = mode.name.lowercase()
        }
    }
}
