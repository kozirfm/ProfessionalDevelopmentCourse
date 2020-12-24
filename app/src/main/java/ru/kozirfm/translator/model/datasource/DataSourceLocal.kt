package ru.kozirfm.translator.model.datasource

import ru.kozirfm.translator.model.data.AppState

interface DataSourceLocal<T> : DataSource<T> {

    suspend fun saveToDB(appState: AppState)
}