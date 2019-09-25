package com.shagalalab.noty

import android.app.Application
import com.shagalalab.noty.di.Injections
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class NoteApp : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@NoteApp)
            modules(listOf(Injections.repositoryModule, Injections.domainModule, Injections.viewmodelModule))
        }
    }
}