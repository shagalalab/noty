package com.shagalalab.noty.domain.repository

import androidx.lifecycle.LiveData
import com.shagalalab.noty.data.model.NoteDbModel

interface NoteRepository {
    suspend fun addNote(note: NoteDbModel)

    fun getNote(id: Long): LiveData<NoteDbModel>

    fun getNotes(): LiveData<List<NoteDbModel>>

    suspend fun updateNote(note: NoteDbModel)

    suspend fun deleteNote(note: NoteDbModel)
}