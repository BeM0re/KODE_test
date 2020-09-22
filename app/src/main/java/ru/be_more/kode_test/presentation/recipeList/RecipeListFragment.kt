package ru.be_more.kode_test.presentation.recipeList

import android.app.SearchManager
import android.graphics.drawable.ClipDrawable
import android.os.Bundle
import android.util.Log
import android.view.*
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.core.content.ContextCompat.getSystemService
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
    private var searchView: SearchView? = null
    private lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? =
        inflater.inflate(R.layout.fragment_list, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setHasOptionsMenu(true)
        super.onViewCreated(view, savedInstanceState)

        initRv()
        initNav(view)
        subscribe()
        viewModel.initViewModel()
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        Log.d("M_RecipeListFragment", "search")
        inflater.inflate(R.menu.menu, menu)

        val searchItem: MenuItem? = menu.findItem(R.id.action_search)
        val searchManager = getSystemService(requireContext(), SearchManager::class.java) as SearchManager
        searchView = searchItem?.actionView as SearchView


        searchView?.setSearchableInfo(searchManager.getSearchableInfo(activity?.componentName))
        searchView?.setOnQueryTextListener(SearchListener(
            {
                (activity?.getSystemService(AppCompatActivity.INPUT_METHOD_SERVICE) as InputMethodManager)
                    .hideSoftInputFromWindow(searchView?.windowToken, 0)
            },
            { query ->
                viewModel.search(query ?: "")
            }
        ))
        return super.onCreateOptionsMenu(menu, inflater)
    }

    private fun subscribe() {
        viewModel.isLoading.observe(viewLifecycleOwner, { showLoading(it) })
        viewModel.dataset.observe(viewLifecycleOwner, { showData(it) })
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
        if (isLoading)
            pb_recipe_list_loading.visibility = View.VISIBLE
        else
            pb_recipe_list_loading.visibility = View.GONE
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