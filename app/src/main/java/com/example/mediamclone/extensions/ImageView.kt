package com.example.mediamclone.extensions

import android.widget.ImageView
import com.bumptech.glide.Glide

fun ImageView.loadImage(url: String, isCircleCrop: Boolean) {

    if (isCircleCrop)
        Glide.with(this).load(url).circleCrop().into(this)
    else
        Glide.with(this).load(url).into(this)

}