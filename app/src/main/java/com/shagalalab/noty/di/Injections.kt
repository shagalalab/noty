package com.shagalalab.noty.di

import androidx.room.Room
import com.shagalalab.noty.data.db.NoteDatabase
import com.shagalalab.noty.data.repository.NoteRepositoryImpl
import com.shagalalab.noty.domain.repository.NoteRepository
import com.shagalalab.noty.domain.usecase.*
import com.shagalalab.noty.presentation.detail.NoteDetailsViewModel
import com.shagalalab.noty.presentation.list.NotesListViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object Injections {

    val repositoryModule = module {
        single { Room.databaseBuilder(androidApplication(), NoteDatabase::class.java, "note.db").build() }
        single { get<NoteDatabase>().noteDao }
        single<NoteRepository> { NoteRepositoryImpl(get()) }
    }

    val domainModule = module {
        single { GetNotesUseCase(get()) }
        single { GetNoteUseCase(get()) }
        factory { AddNoteUseCase(get()) }
        factory { UpdateNoteUseCase(get()) }
        factory { DeleteNoteUseCase(get()) }
    }

    val viewmodelModule = module {
        viewModel { NotesListViewModel(get()) }
        viewModel { NoteDetailsViewModel(get(), get()) }
    }

}