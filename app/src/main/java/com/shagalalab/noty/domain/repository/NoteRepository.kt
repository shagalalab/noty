package com.shagalalab.noty.domain.repository

import androidx.lifecycle.LiveData
import com.shagalalab.noty.data.model.NoteDbModel

interface NoteRepository {
    fun addNote(note: NoteDbModel)

    fun getNote(id: Int): LiveData<NoteDbModel>

    fun getNotes(): LiveData<List<NoteDbModel>>

    fun updateNote(note: NoteDbModel)

    fun deleteNote(note: NoteDbModel)
}