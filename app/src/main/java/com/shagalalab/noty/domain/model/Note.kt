package com.shagalalab.noty.domain.model

import com.shagalalab.noty.data.model.NoteDbModel

data class Note(
    val id: Long,
    val title: String,
    val content: String,
    val type: Int,
    val colorId: Int,
    val createdAt: Long,
    val updatedAt: Long
) {
    constructor(note: NoteDbModel) : this(note.id, note.title, note.content, note.type, note.colorId, note.createdAt, note.updatedAt)

    fun toData() = NoteDbModel(id, title, content, type, colorId, createdAt, updatedAt)
}