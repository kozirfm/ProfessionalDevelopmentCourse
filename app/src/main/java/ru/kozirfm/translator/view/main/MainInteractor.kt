package ru.kozirfm.translator.view.main

import ru.kozirfm.translator.model.data.AppState
import ru.kozirfm.translator.model.data.DataModel
import ru.kozirfm.translator.model.repository.Repository
import ru.kozirfm.translator.model.repository.RepositoryLocal
import ru.kozirfm.translator.viewmodel.Interactor

class MainInteractor(
    private val repositoryRemote: Repository<List<DataModel>>,
    private val repositoryLocal: RepositoryLocal<List<DataModel>>
) : Interactor<AppState> {

    override suspend fun getData(word: String, fromRemoteSource: Boolean): AppState {
        val appState: AppState
        if (fromRemoteSource) {
            appState = AppState.Success(repositoryRemote.getData(word))
            repositoryLocal.saveToDB(appState)
        } else {
            appState = AppState.Success(repositoryLocal.getData(word))
        }
        return appState
    }
}