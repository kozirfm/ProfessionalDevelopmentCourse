package ru.kozirfm.translator.view.base

import ru.kozirfm.translator.model.data.DataModel

interface View {

    fun renderData(dataModel: DataModel)

}
