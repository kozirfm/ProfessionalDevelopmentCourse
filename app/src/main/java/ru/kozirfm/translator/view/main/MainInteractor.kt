package ru.kozirfm.translator.view.main

import ru.kozirfm.translator.model.data.AppState
import ru.kozirfm.translator.model.data.DataModel
import ru.kozirfm.translator.model.repository.Repository
import ru.kozirfm.translator.viewmodel.Interactor

class MainInteractor(
    private val repositoryRemote: Repository<List<DataModel>>,
    private val repositoryLocal: Repository<List<DataModel>>
) : Interactor<AppState> {

    override suspend fun getData(word: String, fromRemoteSource: Boolean): AppState {
        return AppState.Success(
            if (fromRemoteSource) {
                repositoryRemote
            } else {
                repositoryLocal
            }.getData(word)
        )
    }
}