package ru.be_more.kode_test.presentation.recipeList

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_recipe_short.*
import ru.be_more.kode_test.presentation.interfaces.OnRecipeClickListener

class RecipeListItemViewHolder(
    itemView: View,
    private var listener: OnRecipeClickListener
) : RecyclerView.ViewHolder(itemView), LayoutContainer {

    override val containerView: View?
        get() = itemView

    fun setTitle(title: String) {
        tv_list_item_title.text = title
    }

    fun setDescription(description: String) {
        tv_list_item_description.text = description
    }

    fun setImage(imageUrl: String) {
        Glide.with(itemView)
            .load(imageUrl)
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .into(iv_list_item_photo)
    }

    fun setListener(id: String, title: String){
        itemView.setOnClickListener { listener.onRecipeClickListener(id, title) }
    }

}