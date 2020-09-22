package ru.be_more.kode_test.presentation.recipeList

import android.graphics.drawable.ClipDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_list.*
import org.koin.android.ext.android.inject
import ru.be_more.kode_test.R
import ru.be_more.kode_test.domain.model.RecipeShort
import ru.be_more.kode_test.presentation.ViewModelContract
import ru.be_more.kode_test.presentation.interfaces.OnRecipeClickListener

class RecipeListFragment: Fragment(), OnRecipeClickListener {

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

        initRv()
        initNav(view)
        subscribe()
        viewModel.initViewModel()
    }

    private fun subscribe() {
        viewModel.isLoading.observe(viewLifecycleOwner, {showLoading(it)})
        viewModel.dataset.observe(viewLifecycleOwner, {showData(it)})
    }

    private fun showData(data: List<RecipeShort>?) {
        if (data != null) {
            adapter = RecipeListAdapter(data, this)
            recyclerView?.adapter = adapter
            recyclerView?.addItemDecoration(
                DividerItemDecoration(recyclerView?.context, ClipDrawable.HORIZONTAL)
            )
        }
    }

    private fun showLoading(isLoading: Boolean) {

    }

    private fun initNav(view: View) {
        navController = Navigation.findNavController(view)
    }

    private fun initRv(){
        recyclerView = rv_recipe_list
        recyclerView?.layoutManager = LinearLayoutManager(this.context)
    }

    override fun onRecipeClickListener(id: String, title: String) {
        val bundle = Bundle()
        bundle.putString("uuid", id)
        bundle.putString("title", title)
        navController.navigate(R.id.action_recipeListFragment_to_detailsFragment, bundle)
    }
}