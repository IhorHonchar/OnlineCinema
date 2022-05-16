package com.honchar.onlinecinema.core.extensions

import android.view.View

fun View.visibleIfOrGone(predicate: () -> Boolean){
    visibility = if (predicate.invoke()) View.VISIBLE else View.GONE
}

fun View.visibleIfOrInvisible(predicate: () -> Boolean){
    visibility = if (predicate.invoke()) View.VISIBLE else View.INVISIBLE
}

fun View.setClickListener(clickListener: () -> Unit) {
    setOnClickListener { clickListener.invoke() }
}