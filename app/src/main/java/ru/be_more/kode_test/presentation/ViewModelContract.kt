package ru.be_more.kode_test.presentation

import androidx.lifecycle.MutableLiveData
import ru.be_more.kode_test.domain.model.Recipe
import ru.be_more.kode_test.domain.model.RecipeShort

interface ViewModelContract {

    interface BaseViewModel{
        fun loadData()
        fun onDestroy()
        fun saveState()
    }

    interface RecipeListViewModel: BaseViewModel {
        val dataset: MutableLiveData<List<RecipeShort>>
    }

    interface DetailViewModel: BaseViewModel {
        val recipeData: MutableLiveData<Recipe>
    }
}