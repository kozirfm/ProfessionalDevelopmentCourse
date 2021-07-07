package ru.kozirfm.translator.view.main

import ru.kozirfm.model.data.DataModel
import ru.kozirfm.model.data.SearchResult
import ru.kozirfm.repository.repository.Repository
import ru.kozirfm.repository.repository.RepositoryLocal
import ru.kozirfm.core.viewmodel.Interactor

class MainInteractor(
    private val repositoryRemote: Repository<List<SearchResult>>,
    private val repositoryLocal: RepositoryLocal<List<SearchResult>>
) : Interactor<DataModel> {

    override suspend fun getData(word: String, fromRemoteSource: Boolean): DataModel {
        val dataModel: DataModel
        if (fromRemoteSource) {
            dataModel = DataModel.Success(repositoryRemote.getData(word))
            repositoryLocal.saveToDB(dataModel)
        } else {
            dataModel = DataModel.Success(repositoryLocal.getData(word))
        }
        return dataModel
    }
}