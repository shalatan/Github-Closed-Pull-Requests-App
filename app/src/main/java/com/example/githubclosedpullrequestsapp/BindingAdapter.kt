package com.example.githubclosedpullrequestsapp

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("imageUrl")
fun bindImage(imageView: ImageView, imgUrl: String?) {
    Glide.with(imageView)
        .load(imgUrl)
        .into(imageView)
}
