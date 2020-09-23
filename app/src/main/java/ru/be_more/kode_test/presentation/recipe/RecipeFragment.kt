package ru.be_more.kode_test.presentation.recipe

import android.graphics.drawable.ClipDrawable
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.fragment_list.*
import kotlinx.android.synthetic.main.fragment_recipe.*
import org.koin.android.ext.android.inject
import ru.be_more.kode_test.R
import ru.be_more.kode_test.domain.model.Recipe
import ru.be_more.kode_test.presentation.ViewModelContract
import ru.be_more.kode_test.presentation.interfaces.OnRecipeClickListener

class RecipeFragment: Fragment(), OnRecipeClickListener {

    private val viewModel: ViewModelContract.DetailViewModel by inject()
    private var recyclerView : RecyclerView? = null
    private var adapter : SimilarRecipeAdapter? = null
    private lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? =
        inflater.inflate(R.layout.fragment_recipe, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setHasOptionsMenu(true)
        super.onViewCreated(view, savedInstanceState)

        initRecycler()
        subscribe()
        initNav(view)
    }

    override fun onDestroyView() {
        recyclerView?.adapter = null
        recyclerView = null
        adapter = null
        super.onDestroyView()
    }

    private fun initRecycler() {
        recyclerView = rv_similar_recipes
        recyclerView?.layoutManager = LinearLayoutManager(this.context)
    }

    private fun initNav(view: View) {
        navController = Navigation.findNavController(view)
        val id = requireArguments().getString("uuid")

        if (!id.isNullOrEmpty())
            viewModel.initViewModel(id)
    }

    private fun subscribe() {
        viewModel.recipeData.observe(viewLifecycleOwner, { showData(it) })
    }

    private fun showData(recipe: Recipe){
        tv_recipe_title.text = recipe.name
        rb_recipe_difficulty.numStars = recipe.difficulty
        tv_recipe_description.text = recipe.description
        tv_recipe_instruction.text = recipe.instructions

        adapter = SimilarRecipeAdapter(recipe.similar, this)
        recyclerView?.adapter = adapter
        recyclerView?.addItemDecoration(
            DividerItemDecoration(recyclerView?.context, ClipDrawable.HORIZONTAL)
        )

        recipe.images.forEach {url ->
            Glide.with(iv_recipe_photo)
                .load(url)
                .into(iv_recipe_photo)
        }
    }

    override fun onRecipeClickListener(id: String, name: String) {
        val bundle = Bundle()
        bundle.putString("uuid", id)
        bundle.putString("title", name)
        navController.navigate(R.id.action_detailsFragment_self, bundle)
    }

}