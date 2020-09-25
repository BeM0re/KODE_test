package ru.be_more.kode_test.presentation.recipe.photo

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.be_more.kode_test.R
import ru.be_more.kode_test.presentation.interfaces.OnPhotoClickListener

class RecipePhotoAdapter(
    private var dataset: List<String>,
    private val listener: OnPhotoClickListener
) : RecyclerView.Adapter<RecipePhotoViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipePhotoViewHolder {
        val inflater = LayoutInflater.from(parent.context)

        return RecipePhotoViewHolder(inflater.inflate( R.layout.item_recipe_photo, parent, false),
            listener)
    }

    override fun getItemCount(): Int = dataset.size

    override fun onBindViewHolder(holder: RecipePhotoViewHolder, position: Int) {
        with(holder){
            setPhoto(dataset[position])
            setCount(position+1, dataset.size)
            setListener(dataset[position])
        }
    }

}