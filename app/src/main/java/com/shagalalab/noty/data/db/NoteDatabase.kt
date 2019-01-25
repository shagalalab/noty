package com.shagalalab.noty.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.shagalalab.noty.data.model.NoteDbModel

@Database(entities = arrayOf(NoteDbModel::class), version = 1, exportSchema = false)
abstract class NoteDatabase : RoomDatabase() {
    abstract val noteDao: NoteDao
}