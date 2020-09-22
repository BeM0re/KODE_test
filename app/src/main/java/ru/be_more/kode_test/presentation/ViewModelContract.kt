package ru.be_more.kode_test.presentation

import androidx.lifecycle.LiveData
import ru.be_more.kode_test.domain.model.Recipe
import ru.be_more.kode_test.domain.model.RecipeShort

interface ViewModelContract {

    interface BaseViewModel{
        fun initViewModel()
        fun onDestroy()
        fun saveState()
    }

    interface RecipeListViewModel: BaseViewModel {
        val isLoading: LiveData<Boolean>
        val dataset: LiveData<List<RecipeShort>>
    }

    interface DetailViewModel: BaseViewModel {
        val recipeData: LiveData<Recipe>
    }
}