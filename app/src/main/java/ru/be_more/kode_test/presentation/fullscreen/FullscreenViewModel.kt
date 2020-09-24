package ru.be_more.kode_test.presentation.fullscreen

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.be_more.kode_test.domain.InteractorContract
import ru.be_more.kode_test.presentation.ViewModelContract

class FullscreenViewModelImpl (
    private val interactor : InteractorContract.PhotoInteractor
): ViewModel(), ViewModelContract.FullscreenViewModel {

    override val downloadSuccess = MutableLiveData<Boolean>()

    override fun savePhoto(url: String, name: String){
        downloadSuccess.postValue(interactor.savePhoto(url, name))
    }

}