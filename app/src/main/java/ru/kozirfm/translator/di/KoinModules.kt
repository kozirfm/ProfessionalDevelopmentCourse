package ru.kozirfm.translator.di

import androidx.room.Room
import org.koin.core.qualifier.named
import org.koin.dsl.module
import ru.kozirfm.translator.model.data.DataModel
import ru.kozirfm.translator.model.datasource.RetrofitImplementation
import ru.kozirfm.translator.model.datasource.RoomDataBaseImplementation
import ru.kozirfm.translator.model.repository.Repository
import ru.kozirfm.translator.model.repository.RepositoryImplementation
import ru.kozirfm.translator.model.repository.RepositoryImplementationLocal
import ru.kozirfm.translator.model.repository.RepositoryLocal
import ru.kozirfm.translator.room.HistoryDataBase
import ru.kozirfm.translator.view.history.HistoryInteractor
import ru.kozirfm.translator.view.history.HistoryViewModel
import ru.kozirfm.translator.view.main.MainInteractor
import ru.kozirfm.translator.view.main.MainViewModel

val application = module {
    single { Room.databaseBuilder(get(), HistoryDataBase::class.java, "HistoryDB").build() }
    single { get<HistoryDataBase>().historyDao() }
    single<Repository<List<DataModel>>> { RepositoryImplementation(RetrofitImplementation()) }
    single<RepositoryLocal<List<DataModel>>> { RepositoryImplementationLocal(RoomDataBaseImplementation(get()))
    }
}

val mainScreen = module {
    factory { MainViewModel(get()) }
    factory { MainInteractor(get(), get()) }
}

val historyScreen = module {
    factory { HistoryViewModel(get()) }
    factory { HistoryInteractor(get(), get()) }
}