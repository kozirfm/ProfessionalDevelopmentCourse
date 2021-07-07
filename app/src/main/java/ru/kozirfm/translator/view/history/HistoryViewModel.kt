package ru.kozirfm.translator.view.history

import androidx.lifecycle.LiveData
import kotlinx.coroutines.launch
import ru.kozirfm.model.data.DataModel
import ru.kozirfm.repository.parseLocalSearchResults

class HistoryViewModel(private val interactor: HistoryInteractor) :
    ru.kozirfm.core.viewmodel.BaseViewModel<DataModel>() {

    private val liveDataForViewToObserve: LiveData<DataModel> = _mutableLiveData

    fun subscribe(): LiveData<DataModel> {
        return liveDataForViewToObserve
    }

    override fun getData(word: String, isOnline: Boolean) {
        _mutableLiveData.value = DataModel.Loading(null)
        cancelJob()
        viewModelCoroutineScope.launch { startInteractor(word, isOnline) }
    }

    private suspend fun startInteractor(word: String, isOnline: Boolean) {
        _mutableLiveData.postValue(parseLocalSearchResults(interactor.getData(word, isOnline)))
    }

    override fun handleError(error: Throwable) {
        _mutableLiveData.postValue(DataModel.Error(error))
    }

    override fun onCleared() {
        _mutableLiveData.value = DataModel.Success(null)
        super.onCleared()
    }
}
