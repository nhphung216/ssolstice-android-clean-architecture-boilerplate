package com.ssolstice.sample.domain.usecase

import com.ssolstice.sample.data.local.preferences.ThemePreferenceManager
import com.ssolstice.sample.data.model.ThemeMode
import com.ssolstice.sample.domain.repository.ThemeRepository
import javax.inject.Inject

class SetAppThemeUseCase @Inject constructor(
    private val repository: ThemeRepository
) {
    suspend operator fun invoke(mode: ThemeMode) {
        repository.setThemeMode(mode)
    }
}
