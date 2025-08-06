package com.ssolstice.sample.theme

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.dataStore
import com.ssolstice.sample.data.model.ThemeMode

val Context.themeDataStore: DataStore<ThemeMode> by dataStore(
    fileName = "app_theme.pb",
    serializer = AppThemeSerializer
)