package ru.kozirfm.repository.repository

import ru.kozirfm.model.data.SearchResult
import ru.kozirfm.repository.datasource.DataSource

class RepositoryImplementation(private val dataSource: DataSource<List<SearchResult>>) :
    Repository<List<SearchResult>> {

    override suspend fun getData(word: String): List<SearchResult> {
        return dataSource.getData(word)
    }
}
