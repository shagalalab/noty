package com.shagalalab.noty.presentation.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.shagalalab.noty.R
import com.shagalalab.noty.domain.model.Note
import com.shagalalab.noty.presentation.NoteActivity
import kotlinx.android.synthetic.main.fragment_note_details.*
import kotlinx.android.synthetic.main.fragment_note_details.view.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class NoteDetailsFragment : Fragment() {
    private val viewModel: NoteDetailsViewModel by viewModel()

    private var noteId = 0L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.apply {
            noteId = getLong(NoteActivity.NOTE_ID)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_note_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.save.setOnClickListener {
            if (view.noteDetailsContent.text.toString().isNotEmpty()) {
                viewModel.insertNote(Note(noteId, noteDetailsTitle.text.toString(), noteDetailsContent.text.toString())) {
                    clearFocus()
                    it.findNavController().navigateUp()
                }
            } else {
                view.noteDetailsContent.requestFocus()
                view.noteDetailsContent.error = getString(R.string.content_empty)
            }
        }

        view.cancel.setOnClickListener {
            clearFocus()
            it.findNavController().navigateUp()
        }
    }

    private fun clearFocus() {
        noteDetailsTitle.clearFocus()
        noteDetailsContent.clearFocus()
    }
}