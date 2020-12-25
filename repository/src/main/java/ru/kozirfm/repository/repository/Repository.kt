package ru.kozirfm.repository.repository

interface Repository<T> {

    suspend fun getData(word: String): T
}
