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
import kotlinx.android.synthetic.main.fragment_recipe.*
import org.koin.android.ext.android.inject
import ru.be_more.kode_test.R
import ru.be_more.kode_test.domain.model.Recipe
import ru.be_more.kode_test.presentation.ViewModelContract
import ru.be_more.kode_test.presentation.interfaces.OnPhotoClickListener
import ru.be_more.kode_test.presentation.interfaces.OnRecipeClickListener
import ru.be_more.kode_test.presentation.recipe.photo.RecipePhotoAdapter
import ru.be_more.kode_test.presentation.recipe.similar.SimilarRecipeAdapter

class RecipeFragment: Fragment(),
    OnRecipeClickListener,
    OnPhotoClickListener {

    private val viewModel: ViewModelContract.DetailViewModel by inject()

    private var similarRecyclerView : RecyclerView? = null
    private var similarAdapter : SimilarRecipeAdapter? = null

    private var photoRecyclerView : RecyclerView? = null
    private var photoAdapter : RecipePhotoAdapter? = null

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
        Log.d("M_RecipeFragment","on Destroy")
        similarRecyclerView?.adapter = null
        similarRecyclerView = null
        similarAdapter = null
        photoRecyclerView?.adapter = null
        photoRecyclerView = null
        photoAdapter = null
        super.onDestroyView()
    }

    private fun initRecycler() {
        similarRecyclerView = rv_similar_recipes
        similarRecyclerView?.layoutManager = LinearLayoutManager(this.context)
        photoRecyclerView = rv_recipe_photos
        photoRecyclerView?.layoutManager =
            LinearLayoutManager(this.context, LinearLayoutManager.HORIZONTAL,false)
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

        if (recipe.similar.isNotEmpty()){
            tv_recipe_similar_title.visibility = View.VISIBLE
            similarAdapter = SimilarRecipeAdapter(recipe.similar, this)
            similarRecyclerView?.adapter = similarAdapter
            similarRecyclerView?.addItemDecoration(
                DividerItemDecoration(similarRecyclerView?.context, ClipDrawable.HORIZONTAL)
            )
        }
        else
            tv_recipe_similar_title.visibility = View.GONE

        photoAdapter = RecipePhotoAdapter(recipe.images, this)
        photoRecyclerView?.adapter = photoAdapter
    }

    override fun onRecipeClickListener(id: String, name: String) {
        val bundle = Bundle()
        bundle.putString("uuid", id)
        bundle.putString("title", name)
        navController.navigate(R.id.action_detailsFragment_self, bundle)
    }

    override fun onPhotoClickListener(url: String) {
        val bundle = Bundle()
        bundle.putString("url", url)
        bundle.putString("title", viewModel.recipeData.value?.name?:"Recipe photo")
        navController.navigate(R.id.action_detailsFragment_to_fullscreenFragment, bundle)
    }

}