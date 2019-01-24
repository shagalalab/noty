package com.shagalalab.noty.data.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.shagalalab.noty.data.model.NoteDbModel

@Dao
interface NoteDao {
    @Query("SELECT * FROM notes")
    fun getNotes(): LiveData<List<NoteDbModel>>

    @Query("SELECT * FROM notes WHERE id = :id")
    fun getNote(id: Long): LiveData<NoteDbModel>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertNote(note: NoteDbModel)

    @Delete
    fun deleteNote(note: NoteDbModel)
}