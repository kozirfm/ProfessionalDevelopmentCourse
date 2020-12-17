package ru.kozirfm.translator.model.datasource

import ru.kozirfm.translator.model.data.AppState
import ru.kozirfm.translator.model.data.DataModel
import ru.kozirfm.translator.room.HistoryDao
import ru.kozirfm.translator.utils.convertDataModelSuccessToEntity
import ru.kozirfm.translator.utils.mapHistoryEntityToSearchResult

class RoomDataBaseImplementation(private val historyDao: HistoryDao) :
    DataSourceLocal<List<DataModel>> {

    override suspend fun getData(word: String): List<DataModel> {
        return mapHistoryEntityToSearchResult(historyDao.all())
    }

    override suspend fun saveToDB(appState: AppState) {
        convertDataModelSuccessToEntity(appState)?.let {
            historyDao.insert(it)
        }
    }
}
