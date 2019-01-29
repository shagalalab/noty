package com.shagalalab.noty.presentation.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.shagalalab.noty.domain.model.Note
import com.shagalalab.noty.domain.usecase.GetNotesUseCase

class NotesListViewModel(getNotesUseCase: GetNotesUseCase) : ViewModel() {
    val notesList: LiveData<List<Note>> = getNotesUseCase.execute(Unit)
    val hasNotes: LiveData<Boolean> = Transformations.map(notesList) { it.isNotEmpty() }
}