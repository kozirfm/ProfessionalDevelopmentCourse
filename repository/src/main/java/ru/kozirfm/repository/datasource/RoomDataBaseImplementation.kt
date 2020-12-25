package ru.kozirfm.repository.datasource

import ru.kozirfm.model.data.DataModel
import ru.kozirfm.model.data.SearchResult
import ru.kozirfm.repository.room.HistoryDao
import ru.kozirfm.repository.convertDataModelSuccessToEntity
import ru.kozirfm.repository.mapHistoryEntityToSearchResult

class RoomDataBaseImplementation(private val historyDao: HistoryDao) :
    DataSourceLocal<List<SearchResult>> {

    override suspend fun getData(word: String): List<SearchResult> {
        return mapHistoryEntityToSearchResult(historyDao.all())
    }

    override suspend fun saveToDB(dataModel: DataModel) {
        convertDataModelSuccessToEntity(dataModel)?.let {
            historyDao.insert(it)
        }
    }
}
