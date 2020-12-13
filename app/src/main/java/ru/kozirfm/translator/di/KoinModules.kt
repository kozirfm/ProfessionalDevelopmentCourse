package ru.kozirfm.translator.di

import org.koin.core.qualifier.named
import org.koin.dsl.module
import ru.kozirfm.translator.model.data.DataModel
import ru.kozirfm.translator.model.datasource.RetrofitImplementation
import ru.kozirfm.translator.model.datasource.RoomDataBaseImplementation
import ru.kozirfm.translator.model.repository.Repository
import ru.kozirfm.translator.model.repository.RepositoryImplementation
import ru.kozirfm.translator.view.main.MainInteractor
import ru.kozirfm.translator.view.main.MainViewModel

val application = module {
    single<Repository<List<DataModel>>>(named(NAME_REMOTE)) {
        RepositoryImplementation(
            RetrofitImplementation()
        )
    }
    single<Repository<List<DataModel>>>(named(NAME_LOCAL)) {
        RepositoryImplementation(
            RoomDataBaseImplementation()
        )
    }
}

val mainScreen = module {
    factory { MainInteractor(get(named(NAME_REMOTE)), get(named(NAME_LOCAL))) }
    factory { MainViewModel(get()) }
}
