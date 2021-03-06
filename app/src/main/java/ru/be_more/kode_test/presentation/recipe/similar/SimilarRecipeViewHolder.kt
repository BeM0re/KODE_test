package ru.be_more.kode_test.presentation.recipe.similar

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_similar.*
import ru.be_more.kode_test.presentation.interfaces.OnRecipeClickListener

class SimilarRecipeViewHolder(
    itemView: View,
    private var listener: OnRecipeClickListener
) : RecyclerView.ViewHolder(itemView), LayoutContainer {

    override val containerView: View?
        get() = itemView

    fun setTitle(title: String) {
        tv_similar_item_title.text = title
    }

    fun setListener(id: String, title: String){
        tv_similar_item_title.setOnClickListener { listener.onRecipeClickListener(id, title) }
    }

}