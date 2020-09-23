package ru.be_more.kode_test.presentation.recipeList

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.be_more.kode_test.domain.InteractorContract
import ru.be_more.kode_test.domain.model.RecipeShort
import ru.be_more.kode_test.presentation.ViewModelContract
import ru.be_more.kode_test.presentation.recipe.SortDialog
import java.util.*

class RecipeListViewModelImpl (
    private val interactor : InteractorContract.RecipeInteractor
): ViewModel(), ViewModelContract.RecipeListViewModel{

    override val dataset = MutableLiveData<List<RecipeShort>>()
    private var fullData: List<RecipeShort>? = null

    override val isLoading = MutableLiveData<Boolean>()

    @SuppressLint("CheckResult")
    override fun initViewModel() {
        isLoading.postValue(true)
        interactor.getRecipes()
            .subscribe(
                {
                    isLoading.postValue(false)
                    fullData = it
                    dataset.postValue(fullData)
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

    override fun search(query: String) {
        if(query.isEmpty())
            dataset.postValue(fullData)
        else{
            dataset.postValue(
                fullData?.filter { it.name.contains(query, true) ||
                        it.description.contains(query, true) ||
                        it.instructions.contains(query, true) }
            )
        }


    }

    override fun setSort(sortType: SortDialog.SortType) {
        when(sortType){
            SortDialog.SortType.BY_NAME -> {
                fullData = fullData?.sortedBy { it.name }
                dataset.postValue(dataset.value?.sortedBy { it.name })
            }
            SortDialog.SortType.BY_DATE -> {
                fullData = fullData?.sortedBy { it.lastUpdated }
                dataset.postValue(dataset.value?.sortedBy { it.lastUpdated })
            }
        }
    }
}