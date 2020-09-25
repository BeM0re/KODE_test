package ru.be_more.kode_test.presentation

import androidx.lifecycle.LiveData
import ru.be_more.kode_test.domain.model.Recipe
import ru.be_more.kode_test.domain.model.RecipeShort
import ru.be_more.kode_test.presentation.recipe.SortDialog

interface ViewModelContract {

    interface BaseViewModel{
        fun onDestroy()
    }

    interface RecipeListViewModel: BaseViewModel {
        val isLoading: LiveData<Boolean>
        val dataset: LiveData<List<RecipeShort>>
        val savedPosition: LiveData<Int>
        fun initViewModel()
        fun search(query: String)
        fun setSort(sortType: SortDialog.SortType)
        fun saveState(position: Int)
    }

    interface DetailViewModel: BaseViewModel {
        val recipeData: LiveData<Recipe>
        fun initViewModel(id: String)
    }

    interface FullscreenViewModel{
        val downloadSuccess: LiveData<Boolean>
        fun savePhoto(url: String, name: String)
    }
}