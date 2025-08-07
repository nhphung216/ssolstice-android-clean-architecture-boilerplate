package com.ssolstice.sample.data.mapper

import com.ssolstice.sample.data.local.database.NoteEntity
import com.ssolstice.sample.domain.model.NoteModel

fun NoteEntity.toDomain(): NoteModel {
    return NoteModel(
        id = id,
        content = content,
        timestamp = timestamp,
    )
}

fun NoteModel.toEntity(): NoteEntity {
    return NoteEntity(
        id = id,
        content = content,
        timestamp = timestamp,
    )
}