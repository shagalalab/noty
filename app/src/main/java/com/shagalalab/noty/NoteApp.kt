package com.shagalalab.noty

import android.app.Application
import com.shagalalab.noty.di.Injections
import org.koin.android.ext.android.startKoin

class NoteApp : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin(this, listOf(Injections.repositoryModule, Injections.domainModule, Injections.viewmodelModule))
    }
}