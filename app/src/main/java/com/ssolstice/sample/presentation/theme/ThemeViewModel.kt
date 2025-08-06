package com.ssolstice.sample.presentation.theme

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ssolstice.sample.data.model.ThemeMode
import com.ssolstice.sample.domain.usecase.GetAppThemeUseCase
import com.ssolstice.sample.domain.usecase.SetAppThemeUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ThemeViewModel @Inject constructor(
    getAppThemeUseCase: GetAppThemeUseCase,
    private val setAppThemeUseCase: SetAppThemeUseCase
) : ViewModel() {

    val themeMode: StateFlow<ThemeMode> = getAppThemeUseCase()
        .stateIn(viewModelScope, SharingStarted.Eagerly, ThemeMode.AUTO)

    fun setThemeMode(mode: ThemeMode) {
        viewModelScope.launch {
            setAppThemeUseCase(mode)
        }
    }
}
