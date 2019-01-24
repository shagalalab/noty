package com.shagalalab.noty.domain.usecase

import com.shagalalab.noty.domain.model.Note
import com.shagalalab.noty.domain.repository.NoteRepository

class UpdateNoteUseCase(private val repository: NoteRepository) : UseCase<Note, Unit> {

    override fun execute(param: Note) {
        repository.updateNote(param.toData())
    }

}