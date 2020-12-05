package ru.kozirfm.translator.view.main

import ru.kozirfm.translator.presenter.Interactor
import ru.kozirfm.translator.model.data.DataModel
import ru.kozirfm.translator.model.data.SearchResult
import ru.kozirfm.translator.model.repository.Repository
import io.reactivex.Observable

class MainInteractor(
    private val remoteRepository: Repository<List<SearchResult>>,
    private val localRepository: Repository<List<SearchResult>>
) : Interactor<DataModel> {

    override fun getData(word: String, fromRemoteSource: Boolean): Observable<DataModel> {
        return if (fromRemoteSource) {
            remoteRepository.getData(word).map { DataModel.Success(it) }
        } else {
            localRepository.getData(word).map { DataModel.Success(it) }
        }
    }
}
