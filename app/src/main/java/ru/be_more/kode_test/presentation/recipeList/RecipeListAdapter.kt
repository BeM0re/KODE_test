package ru.be_more.kode_test.presentation.recipeList

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.be_more.kode_test.R
import ru.be_more.kode_test.domain.model.RecipeShort
import ru.be_more.kode_test.presentation.interfaces.OnRecipeClickListener

class RecipeListAdapter(
    private var dataset: List<RecipeShort>,
    private val listener: OnRecipeClickListener
) : RecyclerView.Adapter<RecipeListItemViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeListItemViewHolder {
        val inflater = LayoutInflater.from(parent.context)

        return RecipeListItemViewHolder(inflater.inflate( R.layout.item_recipe_short, parent, false),
            listener)
    }

    override fun getItemCount(): Int = dataset.size

    override fun onBindViewHolder(holder: RecipeListItemViewHolder, position: Int) {
        with(holder){
            setTitle(dataset[position].name)
            setDescription(dataset[position].description)
            setImage(dataset[position].image)
            setListener(dataset[position].uuid, dataset[position].name)
        }
    }

}