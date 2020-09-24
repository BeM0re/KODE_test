package ru.be_more.kode_test.presentation.recipe.photo

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_recipe_photo.*
import ru.be_more.kode_test.R
import ru.be_more.kode_test.presentation.interfaces.OnPhotoClickListener

class RecipePhotoViewHolder(
    itemView: View,
    private var listener: OnPhotoClickListener
) : RecyclerView.ViewHolder(itemView), LayoutContainer {

    override val containerView: View?
        get() = itemView

    fun setPhoto(url: String) {
        Glide.with(itemView)
            .load(url)
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .into(item_recipe_photo)
    }

    fun setCount(current: Int, total: Int) {
        item_recipe_photo_counter.text =
            itemView.context.getString(R.string.photo_counter_title, current, total)
    }

    fun setListener(url: String){
        itemView.setOnClickListener {
            listener.onPhotoClickListener(url)
        }
    }
}

