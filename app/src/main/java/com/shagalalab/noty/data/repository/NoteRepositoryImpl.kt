package com.shagalalab.noty.data.repository

import androidx.lifecycle.LiveData
import com.shagalalab.noty.data.db.NoteDao
import com.shagalalab.noty.data.model.NoteDbModel
import com.shagalalab.noty.domain.repository.NoteRepository
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.withContext

class NoteRepositoryImpl(private val noteDao: NoteDao) : NoteRepository {
    override suspend fun addNote(note: NoteDbModel) {
        withContext(IO) {
            println("inside repo")
            noteDao.insertNote(note)
        }
    }

    override fun getNote(id: Long): LiveData<NoteDbModel> {
        return noteDao.getNote(id)
    }

    override fun getNotes(): LiveData<List<NoteDbModel>> {
        return noteDao.getNotes()
    }

    override suspend fun updateNote(note: NoteDbModel) {
        withContext(IO) {
            noteDao.insertNote(note)
        }
    }

    override suspend fun deleteNote(note: NoteDbModel) {
        withContext(IO) {
            noteDao.deleteNote(note)
        }
    }
}