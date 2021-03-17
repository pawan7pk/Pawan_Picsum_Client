package com.chaviacademy.picsumapp.model

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.item_author.view.*

data class AuthorDetails(
    val author: String,
    val author_url: String,
    val filename: String,
    val format: String,
    val height: Int,
    val id: Int,
    val post_url: String,
    val width: Int
) {

    companion object {
        @BindingAdapter("profileImage")
        @JvmStatic
        fun loadImage(view: ImageView, id: Int) {
            Glide.with(view.context)
                .load("https://picsum.photos/300/300?image=${id}")
                .apply(
                    RequestOptions()
                ).into(view.iv_author)

        }
    }

}
