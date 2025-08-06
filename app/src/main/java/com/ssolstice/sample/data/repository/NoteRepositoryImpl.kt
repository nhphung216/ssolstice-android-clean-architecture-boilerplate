package com.ssolstice.sample.data.repository

import com.ssolstice.sample.data.local.database.NoteDao
import com.ssolstice.sample.data.local.database.NoteEntity
import com.ssolstice.sample.domain.repository.NoteRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class NoteRepositoryImpl @Inject constructor(
    val noteDao: NoteDao
) : NoteRepository {

    override fun getAll(): Flow<List<NoteEntity>> = noteDao.getAll()

    override suspend fun insert(noteEntity: NoteEntity) {
        noteDao.insert(noteEntity)
    }
}