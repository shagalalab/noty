package com.shagalalab.noty.domain.usecase

import com.shagalalab.noty.domain.model.Note
import com.shagalalab.noty.domain.repository.NoteRepository

class AddNoteUseCase(private val repository: NoteRepository) : UseCase<Note, Unit> {

    override suspend fun execute(param: Note) {
        repository.addNote(param.toData())
    }

}