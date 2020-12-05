package ru.kozirfm.translator.presenter

import ru.kozirfm.translator.model.data.DataModel
import ru.kozirfm.translator.view.base.View

interface Presenter<T : DataModel, V : View> {

    fun attachView(view: V)

    fun detachView(view: V)

    fun getData(word: String, isOnline: Boolean)
}
