package com.shagalalab.noty.domain.usecase

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.shagalalab.noty.domain.model.Note
import com.shagalalab.noty.domain.repository.NoteRepository

class GetNoteUseCase(private val repository: NoteRepository) : LiveDataUseCase<Long, Note> {

    override fun execute(param: Long): LiveData<Note> {
        return Transformations.map(repository.getNote(param)) { Note(it) }
    }

}