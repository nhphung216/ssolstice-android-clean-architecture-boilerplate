package com.ssolstice.sample.presentation.theme

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.ssolstice.sample.data.model.ThemeMode

@Composable
fun ThemeSettingsScreen(viewModel: ThemeViewModel = hiltViewModel()) {
    val selectedTheme by viewModel.themeMode.collectAsState(initial = ThemeMode.AUTO)
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Column(
            modifier = Modifier.padding(innerPadding)
        ) {
            ThemeMode.entries.forEach { theme ->
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { viewModel.setThemeMode(theme) }
                        .padding(8.dp)
                ) {
                    RadioButton(
                        selected = (selectedTheme == theme),
                        onClick = { viewModel.setThemeMode(theme) }
                    )

                    Text(text = theme.name)
                }
            }
        }
    }
}
