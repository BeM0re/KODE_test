package ru.be_more.kode_test.presentation.recipe

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.be_more.kode_test.domain.InteractorContract
import ru.be_more.kode_test.domain.model.Recipe
import ru.be_more.kode_test.presentation.ViewModelContract

class RecipeViewModelImpl (
    private val interactor : InteractorContract.RecipeInteractor
): ViewModel(), ViewModelContract.DetailViewModel {

    override val recipeData = MutableLiveData<Recipe>()

    @SuppressLint("CheckResult")
    override fun initViewModel(id: String) {
        interactor.getRecipe(id)
            .subscribe(
                { recipeData.postValue(it) },
                { Log.d("M_RecipeViewModelImpl","get recipe error = $it") }
            )
    }

    override fun onDestroy() {
        interactor.release()
    }

}