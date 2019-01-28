package com.shagalalab.noty.presentation.detail

import androidx.lifecycle.ViewModel
import com.shagalalab.noty.domain.model.Note
import com.shagalalab.noty.domain.usecase.AddNoteUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class NoteDetailsViewModel(
    private val addNoteUseCase: AddNoteUseCase
) : ViewModel() {
    private val viewModelJob = Job()
    private val viewModelScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }

    fun insertNote(item: Note, callback: () -> Unit) {
        viewModelScope.launch {
            addNoteUseCase.execute(item)
        }.invokeOnCompletion {
            callback.invoke()
        }
    }
}