package ru.kozirfm.repository.repository

import ru.kozirfm.model.data.DataModel
import ru.kozirfm.model.data.SearchResult
import ru.kozirfm.repository.datasource.DataSourceLocal

class RepositoryImplementationLocal(private val dataSource: DataSourceLocal<List<SearchResult>>) :
    RepositoryLocal<List<SearchResult>> {

    override suspend fun getData(word: String): List<SearchResult> {
        return dataSource.getData(word)
    }

    override suspend fun saveToDB(dataModel: DataModel) {
        dataSource.saveToDB(dataModel)
    }
}