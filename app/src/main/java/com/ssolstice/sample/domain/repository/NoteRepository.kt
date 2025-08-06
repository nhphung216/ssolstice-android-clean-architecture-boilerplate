package com.ssolstice.sample.domain.repository

import com.ssolstice.sample.data.local.database.NoteEntity
import kotlinx.coroutines.flow.Flow

interface NoteRepository {
    fun getAll(): Flow<List<NoteEntity>>
    suspend fun insert(noteEntity: NoteEntity)
}
