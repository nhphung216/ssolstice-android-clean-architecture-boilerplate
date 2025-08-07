package com.ssolstice.sample.data.repository

import com.ssolstice.sample.data.local.database.NoteDao
import com.ssolstice.sample.data.local.database.NoteEntity
import com.ssolstice.sample.data.mapper.toDomain
import com.ssolstice.sample.data.mapper.toEntity
import com.ssolstice.sample.domain.model.NoteModel
import com.ssolstice.sample.domain.repository.NoteRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class NoteRepositoryImpl @Inject constructor(
    val noteDao: NoteDao
) : NoteRepository {

    override fun getAll(): Flow<List<NoteModel>> = noteDao.getAll().map { notes -> notes.map { it.toDomain() } }

    override suspend fun insert(noteEntity: NoteModel) {
        noteDao.insert(noteEntity.toEntity())
    }
}