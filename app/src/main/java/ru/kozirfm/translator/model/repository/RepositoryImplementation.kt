package ru.kozirfm.translator.model.repository

import ru.kozirfm.translator.model.data.SearchResult
import ru.kozirfm.translator.model.datasource.DataSource
import io.reactivex.Observable
import ru.kozirfm.translator.model.repository.Repository

class RepositoryImplementation(private val dataSource: DataSource<List<SearchResult>>) :
    Repository<List<SearchResult>> {

    override fun getData(word: String): Observable<List<SearchResult>> {
        return dataSource.getData(word)
    }
}
