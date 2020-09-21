package ru.be_more.kode_test.presentation.recipeList

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.be_more.kode_test.domain.InteractorContract
import ru.be_more.kode_test.domain.model.RecipeShort
import ru.be_more.kode_test.presentation.ViewModelContract

class RecipeListViewModelImpl (
    private val interactor : InteractorContract.RecipeInteractor
): ViewModel(), ViewModelContract.RecipeListViewModel{

    override val dataset = MutableLiveData<List<RecipeShort>>()

    override fun loadData() {

    }

    override fun onDestroy() {
        interactor.release()
    }

    override fun saveState() {
        TODO("Not yet implemented")
    }

}