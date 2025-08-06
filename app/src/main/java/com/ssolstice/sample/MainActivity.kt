package com.ssolstice.sample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.ssolstice.sample.data.model.ThemeMode
import com.ssolstice.sample.presentation.nav.AppNavGraph
import com.ssolstice.sample.presentation.theme.ThemeViewModel
import com.ssolstice.sample.theme.AppThemeWrapper
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val themeViewModel: ThemeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val themeState by themeViewModel.themeMode.collectAsState(initial = ThemeMode.AUTO)
            AppThemeWrapper(themeMode = themeState) {
                AppNavGraph()
            }
        }
    }
}