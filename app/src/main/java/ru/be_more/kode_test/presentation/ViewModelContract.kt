package ru.be_more.kode_test.presentation

import androidx.lifecycle.LiveData
import ru.be_more.kode_test.domain.model.Recipe
import ru.be_more.kode_test.domain.model.RecipeShort

interface ViewModelContract {

    interface BaseViewModel{
        fun onDestroy()
        fun saveState()
    }

    interface RecipeListViewModel: BaseViewModel {
        fun initViewModel()
        val isLoading: LiveData<Boolean>
        val dataset: LiveData<List<RecipeShort>>
        fun search(query: String)
    }

    interface DetailViewModel: BaseViewModel {
        fun initViewModel(id: String)
        val recipeData: LiveData<Recipe>
    }
}