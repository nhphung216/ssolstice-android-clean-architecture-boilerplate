package com.ssolstice.sample.domain.usecase

import com.ssolstice.sample.data.model.ThemeMode
import com.ssolstice.sample.domain.repository.PreferenceRepository
import javax.inject.Inject

class SetAppThemeUseCase @Inject constructor(
    private val repository: PreferenceRepository
) {
    suspend operator fun invoke(mode: ThemeMode) {
        repository.setThemeMode(mode)
    }
}
