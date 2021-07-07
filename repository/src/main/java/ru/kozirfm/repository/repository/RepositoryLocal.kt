package ru.kozirfm.repository.repository

import ru.kozirfm.model.data.DataModel

interface RepositoryLocal<T> : Repository<T> {

    suspend fun saveToDB(dataModel: DataModel)
}