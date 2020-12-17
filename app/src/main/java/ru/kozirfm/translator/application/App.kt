package ru.kozirfm.translator.application

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import ru.kozirfm.translator.di.application
import ru.kozirfm.translator.di.historyScreen
import ru.kozirfm.translator.di.mainScreen

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(applicationContext)
            modules(listOf(application, mainScreen, historyScreen))
        }
    }


}