package com.ssolstice.sample.domain.usecase

import com.ssolstice.sample.data.local.database.NoteEntity
import com.ssolstice.sample.domain.repository.NoteRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GeNotesUseCase @Inject constructor(
    private val repository: NoteRepository
) {
    operator fun invoke(): Flow<List<NoteEntity>> = repository.getAll()
}
