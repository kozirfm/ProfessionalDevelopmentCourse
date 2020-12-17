package ru.kozirfm.translator.model.repository

import ru.kozirfm.translator.model.data.AppState

interface RepositoryLocal<T> : Repository<T> {

    suspend fun saveToDB(appState: AppState)
}