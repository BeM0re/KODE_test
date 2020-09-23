package ru.be_more.kode_test.presentation.recipe

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.be_more.kode_test.R
import ru.be_more.kode_test.domain.model.RecipeShort
import ru.be_more.kode_test.domain.model.RecipeSimilar
import ru.be_more.kode_test.presentation.interfaces.OnRecipeClickListener

class SimilarRecipeAdapter(var dataset: List<RecipeSimilar>,
                           private val listener: OnRecipeClickListener
) : RecyclerView.Adapter<SimilarRecipeViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SimilarRecipeViewHolder {
        val inflater = LayoutInflater.from(parent.context)

        return SimilarRecipeViewHolder(inflater.inflate( R.layout.item_similar, parent, false),
            listener)
    }

    override fun getItemCount(): Int = dataset.size

    override fun onBindViewHolder(holder: SimilarRecipeViewHolder, position: Int) {
        with(holder){
            setTitle(dataset[position].name)
            setListener(dataset[position].uuid, dataset[position].name)
        }
    }

}