package ru.kozirfm.translator.view.main

import androidx.lifecycle.LiveData
import ru.kozirfm.translator.utils.parseSearchResults
import ru.kozirfm.translator.viewmodel.BaseViewModel
import io.reactivex.disposables.Disposable
import io.reactivex.observers.DisposableObserver
import ru.kozirfm.translator.model.data.DataModel
import javax.inject.Inject

class MainViewModel @Inject constructor(private val interactor: MainInteractor) :
    BaseViewModel<DataModel>() {

    private var appState: DataModel? = null

    fun subscribe(): LiveData<DataModel> {
        return liveDataForViewToObserve
    }

    override fun getData(word: String, isOnline: Boolean) {
        compositeDisposable.add(
            interactor.getData(word, isOnline)
                .subscribeOn(schedulerProvider.io())
                .observeOn(schedulerProvider.ui())
                .doOnSubscribe(doOnSubscribe())
                .subscribeWith(getObserver())
        )
    }

    private fun doOnSubscribe(): (Disposable) -> Unit =
        { liveDataForViewToObserve.value = DataModel.Loading(null) }

    private fun getObserver(): DisposableObserver<DataModel> {
        return object : DisposableObserver<DataModel>() {

            override fun onNext(state: DataModel) {
                appState = parseSearchResults(state)
                liveDataForViewToObserve.value = appState
            }

            override fun onError(e: Throwable) {
                liveDataForViewToObserve.value = DataModel.Error(e)
            }

            override fun onComplete() {
            }
        }
    }
}
