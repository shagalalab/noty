package com.shagalalab.noty.presentation.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.shagalalab.noty.R
import com.shagalalab.noty.domain.usecase.GetNotesUseCase
import kotlinx.android.synthetic.main.fragment_notes_list.view.*
import org.koin.android.ext.android.inject

class NotesListFragment: Fragment() {
    val getNotesUseCase: GetNotesUseCase by inject()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_notes_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.fab.setOnClickListener {
            it.findNavController().navigate(R.id.noteDetailsAction)
        }
    }
}