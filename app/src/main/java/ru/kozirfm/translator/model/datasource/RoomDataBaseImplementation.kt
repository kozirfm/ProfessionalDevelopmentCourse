package ru.kozirfm.translator.model.datasource

import ru.kozirfm.translator.model.data.SearchResult
import io.reactivex.Observable
import ru.kozirfm.translator.model.datasource.DataSource

class RoomDataBaseImplementation : DataSource<List<SearchResult>> {

    override fun getData(word: String): Observable<List<SearchResult>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
