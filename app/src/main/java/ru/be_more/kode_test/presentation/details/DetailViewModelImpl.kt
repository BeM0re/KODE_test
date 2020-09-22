package ru.be_more.kode_test.presentation.details

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.be_more.kode_test.domain.InteractorContract
import ru.be_more.kode_test.domain.model.Recipe
import ru.be_more.kode_test.presentation.ViewModelContract

class DetailViewModelImpl (
    private val interactor : InteractorContract.RecipeInteractor
): ViewModel(), ViewModelContract.DetailViewModel {

    override val recipeData = MutableLiveData<Recipe>()

    override fun initViewModel() {
        TODO("Not yet implemented")
    }

    override fun onDestroy() {
        TODO("Not yet implemented")
    }

    override fun saveState() {
        TODO("Not yet implemented")
    }

}