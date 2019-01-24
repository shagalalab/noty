package com.shagalalab.noty.domain.usecase

import com.shagalalab.noty.domain.model.Note
import com.shagalalab.noty.domain.repository.NoteRepository

class DeleteNoteUseCase(private val repository: NoteRepository) : UseCase<Note, Unit> {

    override fun execute(param: Note) {
        repository.deleteNote(param.toData())
    }

}