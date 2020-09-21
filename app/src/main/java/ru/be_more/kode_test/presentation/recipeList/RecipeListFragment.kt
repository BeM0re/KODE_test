package ru.be_more.kode_test.presentation.recipeList

import androidx.fragment.app.Fragment
import org.koin.android.ext.android.inject
import ru.be_more.kode_test.presentation.ViewModelContract

class RecipeListFragment: Fragment() {

    private val viewModel: ViewModelContract.RecipeListViewModel by inject()
}