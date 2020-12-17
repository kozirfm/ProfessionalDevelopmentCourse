package ru.kozirfm.translator.model.repository

import ru.kozirfm.translator.model.data.AppState
import ru.kozirfm.translator.model.data.DataModel
import ru.kozirfm.translator.model.datasource.DataSourceLocal

class RepositoryImplementationLocal(private val dataSource: DataSourceLocal<List<DataModel>>) :
    RepositoryLocal<List<DataModel>> {

    override suspend fun getData(word: String): List<DataModel> {
        return dataSource.getData(word)
    }

    override suspend fun saveToDB(appState: AppState) {
        dataSource.saveToDB(appState)
    }
}