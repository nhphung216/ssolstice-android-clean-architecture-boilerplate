package com.ssolstice.sample.di

import android.content.Context
import androidx.room.Room
import com.ssolstice.sample.data.local.database.AppDatabase
import com.ssolstice.sample.data.local.database.NoteDao
import com.ssolstice.sample.data.repository.NoteRepositoryImpl
import com.ssolstice.sample.domain.repository.NoteRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    @Provides
    @Singleton
    fun provideSampleRepository(
        noteDao: NoteDao
    ): NoteRepository = NoteRepositoryImpl(noteDao)

    @Provides
    fun provideDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(context, AppDatabase::class.java, "app_database").build()
    }

    @Provides
    fun provideSampleDao(database: AppDatabase) = database.noteDao()
}
