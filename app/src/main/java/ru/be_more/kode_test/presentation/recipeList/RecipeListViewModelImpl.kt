package ru.be_more.kode_test.presentation.recipeList

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.be_more.kode_test.domain.InteractorContract
import ru.be_more.kode_test.domain.model.RecipeShort
import ru.be_more.kode_test.presentation.ViewModelContract

class RecipeListViewModelImpl (
    private val interactor : InteractorContract.RecipeInteractor
): ViewModel(), ViewModelContract.RecipeListViewModel{

    override val dataset = MutableLiveData<List<RecipeShort>>()
    override val isLoading = MutableLiveData<Boolean>()

    @SuppressLint("CheckResult")
    override fun initViewModel() {
        isLoading.postValue(true)
        interactor.getRecipes()
            .subscribe(
                {
                    isLoading.postValue(false)
                    dataset.postValue(it)
                },
                { Log.e("M_RecipeListViewModelIm","Get list error = $it") }
            )

    }

    override fun onDestroy() {
        interactor.release()
    }

    override fun saveState() {
        TODO("Not yet implemented")
    }

}