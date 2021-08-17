package com.moviedb.utils

import android.app.Application
import com.moviedb.home.di.MovieModule
import com.moviedb.moviedetail.di.ModuleDetail
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration

class Application2: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin (appDeclaration = KoinAppDeclarationProvider.get(this))
    }
}

object KoinAppDeclarationProvider {

    @Suppress("LongMethod")
    fun get(application: Application): KoinAppDeclaration = {

        androidContext(application)

        MovieModule().load()
        ModuleDetail().load()
    }
}