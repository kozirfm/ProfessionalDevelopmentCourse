package ru.kozirfm.translator.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import ru.kozirfm.translator.view.main.MainActivity

@Module
abstract class ActivityModule {

    @ContributesAndroidInjector
    abstract fun contributeMainActivity(): MainActivity
}
