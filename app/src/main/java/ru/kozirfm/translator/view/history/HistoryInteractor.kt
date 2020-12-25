package ru.kozirfm.translator.view.history

import ru.kozirfm.model.data.DataModel
import ru.kozirfm.model.data.SearchResult
import ru.kozirfm.repository.repository.Repository
import ru.kozirfm.repository.repository.RepositoryLocal

class HistoryInteractor(
    private val repositoryRemote: Repository<List<SearchResult>>,
    private val repositoryLocal: RepositoryLocal<List<SearchResult>>
) : ru.kozirfm.core.viewmodel.Interactor<DataModel> {

    override suspend fun getData(word: String, fromRemoteSource: Boolean): DataModel {
        return DataModel.Success(
            if (fromRemoteSource) {
                repositoryRemote
            } else {
                repositoryLocal
            }.getData(word)
        )
    }
}
