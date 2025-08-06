package com.ssolstice.sample.domain.usecase

import com.ssolstice.sample.data.model.ThemeMode
import com.ssolstice.sample.domain.repository.ThemeRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetSamplesUseCase @Inject constructor(
    private val repository: ThemeRepository
) {
    operator fun invoke(): Flow<ThemeMode> = repository.getThemeFlow()
}
