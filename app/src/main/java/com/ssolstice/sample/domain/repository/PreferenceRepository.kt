package com.ssolstice.sample.domain.repository

import com.ssolstice.sample.data.model.ThemeMode
import kotlinx.coroutines.flow.Flow

interface PreferenceRepository {
    fun getThemeFlow(): Flow<ThemeMode>
    suspend fun setThemeMode(mode: ThemeMode)
}
