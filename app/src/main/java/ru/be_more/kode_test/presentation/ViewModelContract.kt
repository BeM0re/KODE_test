package ru.be_more.kode_test.presentation

import androidx.lifecycle.LiveData
import ru.be_more.kode_test.domain.model.Recipe
import ru.be_more.kode_test.domain.model.RecipeShort
import ru.be_more.kode_test.presentation.recipe.SortDialog

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
        fun setSort(sortType: SortDialog.SortType)
    }

    interface DetailViewModel: BaseViewModel {
        fun initViewModel(id: String)
        val recipeData: LiveData<Recipe>
    }

    interface FullscreenViewModel{
        val downloadSuccess: LiveData<Boolean>
        fun savePhoto(url: String, name: String)
    }
}