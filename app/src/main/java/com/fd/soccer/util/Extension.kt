package com.fd.soccer.util

import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.fd.soccer.R

fun View.hide() {
    visibility = View.GONE
}

fun View.show() {
    visibility = View.VISIBLE
}

fun ImageView.loadImage(url: String) {
    Glide.with(this)
        .load(url)
        .centerCrop()
        .placeholder(R.drawable.ic_placeholder)
        .into(this)
}