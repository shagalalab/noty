package com.shagalalab.noty.presentation.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import com.shagalalab.noty.R
import kotlinx.android.synthetic.main.fragment_notes_list.view.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class NotesListFragment : Fragment() {
    private val viewModel: NotesListViewModel by viewModel()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_notes_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.fab.setOnClickListener {
            it.findNavController().navigate(R.id.noteDetailsAction)
        }

        viewModel.notesList.observe(viewLifecycleOwner, Observer { notes ->
            println("notes size = ${notes.size}")
        })

        viewModel.hasNotes.observe(viewLifecycleOwner, Observer { hasNotes ->
            if (hasNotes) {
                view.emptyView.visibility = View.GONE
            } else {
                view.emptyView.visibility = View.VISIBLE
            }
        })
    }
}