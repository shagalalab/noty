package com.shagalalab.noty.data.repository

import androidx.lifecycle.LiveData
import com.shagalalab.noty.data.db.NoteDao
import com.shagalalab.noty.data.model.NoteDbModel
import com.shagalalab.noty.domain.repository.NoteRepository

class NoteRepositoryImpl(private val noteDao: NoteDao) : NoteRepository {
    override fun addNote(note: NoteDbModel) {
        noteDao.insertNote(note)
    }

    override fun getNote(id: Long): LiveData<NoteDbModel> {
        return noteDao.getNote(id)
    }

    override fun getNotes(): LiveData<List<NoteDbModel>> {
        return noteDao.getNotes()
    }

    override fun updateNote(note: NoteDbModel) {
        return noteDao.insertNote(note)
    }

    override fun deleteNote(note: NoteDbModel) {
        noteDao.deleteNote(note)
    }
}