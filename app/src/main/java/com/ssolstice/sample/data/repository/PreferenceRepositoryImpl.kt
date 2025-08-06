package com.ssolstice.sample.data.repository

import com.ssolstice.sample.data.local.preferences.PreferenceManager
import com.ssolstice.sample.data.model.ThemeMode
import com.ssolstice.sample.domain.repository.PreferenceRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class PreferenceRepositoryImpl @Inject constructor(
    private val preferenceManager: PreferenceManager
) : PreferenceRepository {

    override fun getThemeFlow(): Flow<ThemeMode> = preferenceManager.themeFlow

    override suspend fun setThemeMode(mode: ThemeMode) {
        preferenceManager.saveTheme(mode)
    }
}
