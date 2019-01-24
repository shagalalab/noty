package com.shagalalab.noty.domain.usecase

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.shagalalab.noty.domain.model.Note
import com.shagalalab.noty.domain.repository.NoteRepository

class GetNotesUseCase(private val repository: NoteRepository) : LiveDataUseCase<Unit, List<Note>> {

    override fun execute(param: Unit): LiveData<List<Note>> {
        return Transformations.map(repository.getNotes()) { notes ->
            notes.map { note ->
                Note(note)
            }
        }
    }

}