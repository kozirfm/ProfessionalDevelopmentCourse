package ru.kozirfm.translator.di

import androidx.room.Room
import org.koin.dsl.module
import ru.kozirfm.model.data.SearchResult
import ru.kozirfm.repository.datasource.RetrofitImplementation
import ru.kozirfm.repository.datasource.RoomDataBaseImplementation
import ru.kozirfm.repository.repository.Repository
import ru.kozirfm.repository.repository.RepositoryImplementation
import ru.kozirfm.repository.repository.RepositoryImplementationLocal
import ru.kozirfm.repository.repository.RepositoryLocal
import ru.kozirfm.repository.room.HistoryDataBase
import ru.kozirfm.translator.view.history.HistoryInteractor
import ru.kozirfm.translator.view.history.HistoryViewModel
import ru.kozirfm.translator.view.main.MainInteractor
import ru.kozirfm.translator.view.main.MainViewModel

val application = module {
    single { Room.databaseBuilder(get(), HistoryDataBase::class.java, "HistoryDB").build() }
    single { get<HistoryDataBase>().historyDao() }
    single<Repository<List<SearchResult>>> { RepositoryImplementation(RetrofitImplementation()) }
    single<RepositoryLocal<List<SearchResult>>> { RepositoryImplementationLocal(RoomDataBaseImplementation(get()))
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