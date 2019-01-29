package com.shagalalab.noty.presentation.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.shagalalab.noty.R
import com.shagalalab.noty.domain.model.Note
import com.shagalalab.noty.presentation.NoteActivity.Companion.NOTE_ID
import kotlinx.android.synthetic.main.item_note.view.*

class NotesAdapter : ListAdapter<Note, NotesAdapter.NoteViewHolder>(NoteDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        return NoteViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_note, parent, false))
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val bundle = Bundle()
        bundle.putLong(NOTE_ID, getItem(position).id)
        holder.bind(getItem(position), View.OnClickListener {
            it.findNavController().navigate(R.id.noteDetailsAction, bundle)
        })
    }

    class NoteViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(item: Note, onClickListener: View.OnClickListener) {
            itemView.itemTitle.text = item.title
            itemView.itemContent.text = item.content
            itemView.setOnClickListener(onClickListener)
        }
    }
}

private class NoteDiffCallback : DiffUtil.ItemCallback<Note>() {

    override fun areItemsTheSame(oldItem: Note, newItem: Note) = oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: Note, newItem: Note) = oldItem == newItem

}