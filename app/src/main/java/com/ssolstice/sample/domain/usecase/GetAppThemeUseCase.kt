package com.ssolstice.sample.domain.usecase

import com.ssolstice.sample.data.model.ThemeMode
import com.ssolstice.sample.domain.repository.PreferenceRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAppThemeUseCase @Inject constructor(
    private val repository: PreferenceRepository
) {
    operator fun invoke(): Flow<ThemeMode> = repository.getThemeFlow()
}
