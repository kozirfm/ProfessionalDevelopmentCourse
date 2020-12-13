package ru.kozirfm.translator.application

import android.app.Application
import org.koin.core.context.startKoin
import ru.kozirfm.translator.di.application
import ru.kozirfm.translator.di.mainScreen

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(listOf(application, mainScreen))
        }
    }


}