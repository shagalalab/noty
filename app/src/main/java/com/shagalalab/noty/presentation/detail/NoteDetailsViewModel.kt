package com.shagalalab.noty.presentation.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.shagalalab.noty.domain.model.Note
import com.shagalalab.noty.domain.usecase.AddNoteUseCase
import com.shagalalab.noty.domain.usecase.GetNoteUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class NoteDetailsViewModel(
    private val addNoteUseCase: AddNoteUseCase,
    private val getNoteUseCase: GetNoteUseCase
) : ViewModel() {
    private val viewModelJob = Job()
    private val viewModelScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }

    fun getNote(id: Long): LiveData<Note> = getNoteUseCase.execute(id)

    fun insertNote(item: Note, callback: () -> Unit) {
        viewModelScope.launch {
            addNoteUseCase.execute(item)
        }.invokeOnCompletion {
            callback.invoke()
        }
    }
}