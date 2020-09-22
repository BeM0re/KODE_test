package ru.be_more.kode_test.presentation.recipeList

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import org.koin.android.ext.android.inject
import ru.be_more.kode_test.R
import ru.be_more.kode_test.domain.model.RecipeShort
import ru.be_more.kode_test.presentation.ViewModelContract

class RecipeListFragment: Fragment() {

    private val viewModel: ViewModelContract.RecipeListViewModel by inject()
    private var recyclerView : RecyclerView? = null
    private var adapter : RecipeListAdapter? = null
    private lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? =
        inflater.inflate(R.layout.fragment_list, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initNav(view)
        subscribe()
    }

    private fun subscribe() {
        viewModel.isLoading.observe(viewLifecycleOwner, {showLoading(it)})
        viewModel.dataset.observe(viewLifecycleOwner, {showData(it)})

    }

    private fun showData(data: List<RecipeShort>?) {

    }

    private fun showLoading(isLoading: Boolean) {

    }

    private fun initNav(view: View) {
        navController = Navigation.findNavController(view)
    }
}