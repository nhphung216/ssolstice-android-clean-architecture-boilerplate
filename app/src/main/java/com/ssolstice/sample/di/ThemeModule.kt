package com.ssolstice.sample.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStoreFile
import com.ssolstice.sample.data.local.preferences.PreferenceManager
import com.ssolstice.sample.data.repository.PreferenceRepositoryImpl
import com.ssolstice.sample.domain.repository.PreferenceRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ThemeModule {

    @Provides
    @Singleton
    fun provideThemeRepository(
        pref: PreferenceManager
    ): PreferenceRepository = PreferenceRepositoryImpl(pref)

    @Provides
    @Singleton
    fun providePreferenceManager(
        dataStore: DataStore<Preferences>
    ): PreferenceManager = PreferenceManager(dataStore)

    @Provides
    @Singleton
    fun provideDataStore(
        @ApplicationContext context: Context
    ): DataStore<Preferences> {
        return PreferenceDataStoreFactory.create {
            context.preferencesDataStoreFile("theme_prefs")
        }
    }
}
