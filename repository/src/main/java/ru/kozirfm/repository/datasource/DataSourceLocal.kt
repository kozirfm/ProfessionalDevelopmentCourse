package ru.kozirfm.repository.datasource

import ru.kozirfm.model.data.DataModel

interface DataSourceLocal<T> : DataSource<T> {

    suspend fun saveToDB(dataModel: DataModel)
}