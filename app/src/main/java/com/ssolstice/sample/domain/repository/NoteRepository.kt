package com.ssolstice.sample.domain.repository

import com.ssolstice.sample.data.local.database.NoteEntity
import com.ssolstice.sample.domain.model.NoteModel
import kotlinx.coroutines.flow.Flow

interface NoteRepository {
    fun getAll(): Flow<List<NoteModel>>
    suspend fun insert(noteEntity: NoteModel)
}
