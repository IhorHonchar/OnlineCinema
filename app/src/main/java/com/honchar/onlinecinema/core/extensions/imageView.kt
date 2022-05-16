package com.honchar.onlinecinema.core.extensions

import android.widget.ImageView
import androidx.annotation.DrawableRes
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy

fun ImageView.loadImage(url: String, @DrawableRes placeholder: Int){
    Glide.with(this.context)
        .asDrawable()
        .load(url)
        .diskCacheStrategy(DiskCacheStrategy.DATA)
        .skipMemoryCache(false)
        .error(placeholder)
        .into(this)
}